package com.testingedu.jdbcdemo.service;

import com.testingedu.jdbcdemo.domain.dao.BaseDao;
import com.testingedu.jdbcdemo.domain.jpa.Card;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.List;

@Service
public class CardService extends BaseDao{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CardService.class);

    public Integer saveCard(List<Card> cardList){
        getJDBCConnection();
        String sql=null;

        if(CollectionUtils.isEmpty(cardList)){
            logger.info("传入参数不能空");
        }else{
            for (Card card: cardList){
                sql = "insert into card(cid) VALUES (?)";
                try {
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1,card.getCid());
                    Integer result = pstmt.executeUpdate();
                    logger.info("数据存储成功",result);
                    return result;

                } catch (SQLException e) {
                    logger.info("数据存储异常",e);

                }finally {
                    closeAll();
                }
            }
        }
        return 0;
    }
}
