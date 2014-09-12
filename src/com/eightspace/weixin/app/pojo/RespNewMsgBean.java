/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 被动响应消息之回复图文消息
 * 
 * @author wangz
 * @date 2014-5-5
 * @since 1.0
 */
public class RespNewMsgBean extends RespBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -8827150298794022200L;

    // 图文消息个数，限制为10条以内
    private Integer ArticleCount;

    // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    private List<RespArticleMsgBean> Articles;



    /**
     * @return the articleCount
     */
    public Integer getArticleCount() {
        return ArticleCount;
    }



    /**
     * @param articleCount
     *            the articleCount to set
     */
    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }



    /**
     * @return the articles
     */
    public List<RespArticleMsgBean> getArticles() {
        return Articles;
    }



    /**
     * @param articles
     *            the articles to set
     */
    public void setArticles(List<RespArticleMsgBean> articles) {
        Articles = articles;
    }

}
