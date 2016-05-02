package com.lhx.taotao.service.impl;

import com.lhx.taotao.mapper.item.TbItemMapper;
import com.lhx.taotao.model.TbItem;
import com.lhx.taotao.model.TbItemExample;
import com.lhx.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xin on 16-5-1 下午11:28
 *
 * @project taotao
 * @package com.lhx.taotao.service.impl
 * @Description 商品管理
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper ;


    @Override
    public TbItem getItemById(long itemId) {
        TbItemExample example = new TbItemExample();
        //添加查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list.size() > 0){
            TbItem item = list.get(0);
            return item ;
        }
        return null;
    }
}
