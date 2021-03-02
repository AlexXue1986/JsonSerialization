package com.leo.cpl.entity;

import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by xueqingqing on 3/2/21 11:20
 * Email: qingqing.xue@ifchange.com
 */
public class FieldEntity {
    private final VariableElement mElement;
    private final String mSimpleName;

    public FieldEntity (VariableElement element) {
        mElement = element;
        mSimpleName = element.getEnclosingElement().getSimpleName().toString();
    }

    public VariableElement getElement() {
        return mElement;
    }

    public String getClassSimpleName() {
        return mSimpleName;
    }
}
