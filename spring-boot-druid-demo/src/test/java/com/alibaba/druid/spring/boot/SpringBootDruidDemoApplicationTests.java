package com.alibaba.druid.spring.boot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("multi-datasource")
public class SpringBootDruidDemoApplicationTests {

	@Resource
	private DruidDataSource dataSourceOne;

	@Test
	public void testDataSourceOne() throws SQLException {

		assertThat(dataSourceOne.getUrl()).isEqualTo("jdbc:h2:file:./demo-db");
		assertThat(dataSourceOne.getUsername()).isEqualTo("sa");
		assertThat(dataSourceOne.getPassword()).isEqualTo("sa");
		assertThat(dataSourceOne.getDriverClassName()).isEqualTo("org.h2.Driver");

		assertThat(dataSourceOne.getInitialSize()).isEqualTo(5);

		assertThat(dataSourceOne.getMaxActive()).isEqualTo(10);
		assertThat(dataSourceOne.getMaxWait()).isEqualTo(10000);
	}
}
