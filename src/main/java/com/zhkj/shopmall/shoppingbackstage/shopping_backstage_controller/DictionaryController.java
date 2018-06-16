package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.DictionaryEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/getDictionaryAllMsg")
    public List<DictionaryEntity> getAllMsg(){
        List<DictionaryEntity> list=dictionaryService.getAllMsg();
        return list;
    }
    @RequestMapping("/getDictionaryMsgByType")
    public List<DictionaryEntity> getMsgByType(DictionaryEntity dictionaryEntity) {
        List<DictionaryEntity> list=dictionaryService.getMsgByType(dictionaryEntity);
        return list;
    }

    @RequestMapping("/saveDictionaryMsg")
    public int saveMsg(DictionaryEntity dictionaryEntity) {
        int result = dictionaryService.saveMsg(dictionaryEntity);
        return result;
    }

    @RequestMapping("/delDictionaryMsgById")
    public int delMsgById(DictionaryEntity dictionaryEntity) {
        int result = dictionaryService.delMsgById(dictionaryEntity);
        return result;
    }

    @RequestMapping("/updateDictionaryMsg")
    public int updateMsg(DictionaryEntity dictionaryEntity) {
        int result = dictionaryService.updateMsg(dictionaryEntity);
        return result;
    }


}
