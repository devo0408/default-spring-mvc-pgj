package com.example.demo;

import com.devo.data.GlobalServerValueRepository;
import com.devo.data.GlobalServerValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class GlobalServerValueServiceTest {

    //
    @Autowired // let Spring instantiate the instance to test
    private GlobalServerValueService globalServerValueService;

    @MockBean // let Spring instantiate the instance to test
    private GlobalServerValueRepository globalServerValueRepository;

    @Test
    public void performProvision_shouldPass() {
        UserData userData = new UserData("userid", 30, 1, "spot", 1);

        String result = provisionService.performProvision(userData);
        assertThat(result, is(equalTo("Success: User userid has been added to the database")));
    }
}
