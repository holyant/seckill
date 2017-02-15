package org.seckill.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
	}

	@Test
	public void testGetById() {
		long id = 1;
		Seckill seckill = seckillService.getById(id);
		logger.info("{}", seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		long id = 1;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("{}", exposer);
	}

	@Test
	public void testExecuteSeckill() {
		long id = 1000;
		long phone = 13505878181L;
		String md5 = "";
		SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
		logger.info("{}", execution);
	}

}
