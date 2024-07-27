package br.com.jandernery.transaction_caju;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testGetHelloTransaction() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/transaction"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Transaction"));
    }

    @Test
    public void testTransactionCreate() throws Exception{
        String payloadTransaction = "{\"account\":\"123\",\"totalAmount\":100.00, \"mcc\": \"5811\", \"merchant\": \"PADARIA DO ZE SAO PAULO BR\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadTransaction)
        ).andExpect(status().isOk()).andExpect(content().json(payloadTransaction));
    }
}
