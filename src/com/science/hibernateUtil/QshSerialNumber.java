package com.science.hibernateUtil;

/**
 * �Զ������й���Ķ�����(����)
 * ���ɵĸ�ʽ��: 2012092600001 ǰ�漸λΪ��ǰ������,������λΪϵͳ���������͵ı��
 * ԭ��: 
 *      1.��ȡ��ǰ���ڸ�ʽ��ֵ;
 *      2.��ȡ�ļ�,�ϴα�ŵ�ֵ+1��Ϊ��ǰ�˴α�ŵ�ֵ
 *      (�µ�һ������´�1��ʼ���)
 */
public abstract class QshSerialNumber {
    public synchronized String getSerialNumber() {
        return process();
    }
    protected abstract String process();
}

