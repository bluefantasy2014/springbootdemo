package com.test123.springbootdemo;

import com.test123.springbootdemo.document.Dict;
import com.test123.springbootdemo.repository.DictMongoRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hotleave
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoDbTest {
  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private DictMongoRepository mongoRepository;

  @Test
  public void insert() {
    Dict dict = new Dict();
    dict.setCode("code");
    dict.setName("name");
    dict.setRank(1);

    mongoTemplate.insert(dict);

    Dict fromDb = mongoRepository.findOne(dict.getId());

    Assert.assertNotNull(fromDb);
    Assert.assertEquals(dict.getCode(), fromDb.getCode());
  }
}
