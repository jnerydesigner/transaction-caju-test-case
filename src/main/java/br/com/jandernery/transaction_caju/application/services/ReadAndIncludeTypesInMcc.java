package br.com.jandernery.transaction_caju.application.services;


import br.com.jandernery.transaction_caju.domain.model.MccSpecialityMerchantModel;
import br.com.jandernery.transaction_caju.infra.repository.MccSpecialityMerchantRepository;
import org.apache.poi.hpsf.Decimal;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;

@Service
public class ReadAndIncludeTypesInMcc {

    @Autowired
    MccSpecialityMerchantRepository mccSpecialityMerchantRepository;

    public void readFile() throws IOException {
        // Use ClassPathResource para carregar o arquivo do classpath
        ClassPathResource resource = new ClassPathResource("types.xlsx");

        try (InputStream file = resource.getInputStream()) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();



                MccSpecialityMerchantModel mccModel = new MccSpecialityMerchantModel();
                String specialityIncludeTable = "";
                String mccIncludeTable ="";


                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            specialityIncludeTable = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            DecimalFormat df = new DecimalFormat("#.##");
                            String formattedDecimal = df.format(cell.getNumericCellValue());
                            mccIncludeTable = formattedDecimal;
                            break;
                        default:
                            System.out.println("Tipo de célula não suportado.");
                            break;
                    }
                }



                mccModel.setSpeciality(specialityIncludeTable);
                mccModel.setMcc(mccIncludeTable);
                mccSpecialityMerchantRepository.save(mccModel);
            }

            workbook.close();
        }
    }
}
