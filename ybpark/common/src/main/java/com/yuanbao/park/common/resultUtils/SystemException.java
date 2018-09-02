package com.yuanbao.park.common.resultUtils;


/**
 * 自定义非检查型异常
 */
public class SystemException extends RuntimeException {
    private MessageEnum messageEnum;
    public SystemException() {
    }

    
    public SystemException(MessageEnum messageEnum) {
        this.messageEnum=messageEnum;
    }

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }

    public void setMessageEnum(MessageEnum messageEnum) {
        this.messageEnum = messageEnum;
    }
}
