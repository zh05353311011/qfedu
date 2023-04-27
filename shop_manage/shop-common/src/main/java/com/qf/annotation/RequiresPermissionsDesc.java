package com.qf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Զ���ע��, ����Ȩ������
 * @Target : ��ע�������Ŀ��, Ҳ�����Զ�������ע��������ʹ��
 * ElementType.TYPE: �ӿڡ��ࡢö�١�ע��
 * ElementType.METHOD : ����
 *
 * @Retention ָ��ע��ı���λ��
 * RetentionPolicy.RUNTIME : �������͵�Annotations����JVM����,
 * 							  ����������������ʱ��JVM������ʹ�÷�����ƵĴ�������ȡ��ʹ��
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermissionsDesc {

	/**
	 * �˵�����
	 * @return
	 */
	String[] menu();


	/**
	 * ��ť����
	 * @return
	 */
	String button();
}
