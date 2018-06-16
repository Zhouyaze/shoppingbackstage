package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_dictionary;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.DictionaryEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_dictionary.DictionaryMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

//    @Autowired
//    private KafkaServiceImpl kafkaService;
    @Autowired
    private DictionaryMapper dictionaryMapper;


    @Override
    public List<DictionaryEntity> getAllMsg() {
        List<DictionaryEntity> list=dictionaryMapper.getAllMsg();
        return list;
    }

    @Override
    public List<DictionaryEntity> getMsgByType(DictionaryEntity dictionaryEntity) {
        List<DictionaryEntity> list=dictionaryMapper.getMsgByType(dictionaryEntity);
        return list;
    }

    @Override
    public int saveMsg(DictionaryEntity dictionaryEntity) {
        int result = dictionaryMapper.saveMsg(dictionaryEntity);
        return result;
    }

    @Override
    public int delMsgById(DictionaryEntity dictionaryEntity) {
        int result = dictionaryMapper.delMsgById(dictionaryEntity);
        return result;
    }

    @Override
    public int updateMsg(DictionaryEntity dictionaryEntity) {
        int result = dictionaryMapper.updateMsg(dictionaryEntity);
        return result;
    }
}
