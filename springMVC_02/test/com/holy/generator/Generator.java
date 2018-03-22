package com.holy.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Generator {
	/**
	 * Mapper.xml文件已经存在时，如果进行重新generator时,文件不被覆盖而是进行内容追加，结果导致mybatis解析失败。
	 * 解决方法：删除原来已经生成的mapper xml文件再进行生成。 对于po类和mapper，Generator直接生成文件，如果同名文件存在则覆盖！
	 */
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("config/mybatis/generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}
	private ApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
		// 读取spring的上下文，然后封装到ctx
		ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testSelectByExample() {
		/*ItemsMapper mapper = (ItemsMapper) ctx.getBean("itemsMapper");
		ItemsExample example = new ItemsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("背包"); //like 需要自己拼接% %
		List<Items> list = mapper.selectByExample(example);
		System.out.println(list);*/
	}
}
