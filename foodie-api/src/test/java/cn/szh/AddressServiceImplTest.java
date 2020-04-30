package cn.szh;

import cn.szh.mapper.UserAddressMapper;
import cn.szh.pojo.UserAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImplTest {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Test
    public void queryAll() {
//        Example example = new Example(UserAddress.class);
//        Example.Criteria criteria = example.createCriteria();
//        String userId = "1908189H7TNWDTXP";
//        criteria.andEqualTo("userId",userId);
//        List<UserAddress> userAddresses = userAddressMapper.selectByExample(example);
        UserAddress ua = new UserAddress();
        ua.setUserId("1908189H7TNWDTXP");
        List<UserAddress> userAddresses = userAddressMapper.select(ua);
        System.out.println(userAddresses);
    }
}