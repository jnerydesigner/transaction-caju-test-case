package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.domain.model.EstablishmentModel;
import br.com.jandernery.transaction_caju.domain.model.MerchantModel;
import br.com.jandernery.transaction_caju.infra.repository.EstablishmentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Optional;


@Service
public class ReadXlsAndIncludeMerchant {

    @Autowired
    EstablishmentRepository establishmentRepository;


    public void readFileAndInclude() throws IOException {
        ClassPathResource resource = new ClassPathResource("merchant.xlsx");
        MerchantModel merchantModel = new MerchantModel();

        try(InputStream file = resource.getInputStream()){
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case STRING:
                            merchantModel.setMerchant(cell.getStringCellValue());
                            break;

                        case NUMERIC:
                            DecimalFormat df = new DecimalFormat("#.##");
                            String formatDecimalMcc = df.format(cell.getNumericCellValue());
                            merchantModel.setMcc(formatDecimalMcc);
                            break;
                        default:
                            System.out.println("Tipo de célula não suportado.");
                            break;

                    }
                }
                Optional<EstablishmentModel> establishmentModel = establishmentRepository.findEstablishmentByNameOpt(merchantModel.getMerchant());

                if(establishmentModel.isEmpty()){
                    EstablishmentModel establishment = new EstablishmentModel();
                    establishment.setMerchant(merchantModel.getMerchant());
                    establishment.setMcc(merchantModel.getMcc());

                    establishmentRepository.save(establishment);
                }
            }
            workbook.close();
        }
    }
}
