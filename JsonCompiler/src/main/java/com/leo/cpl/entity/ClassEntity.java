package com.leo.cpl.entity;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.TypeElement;

/**
 * Created by xueqingqing on 3/2/21 11:13
 * Email: qingqing.xue@ifchange.com
 */
public class ClassEntity {

    private final TypeElement mElement;
    private final String mSimpleName;
    private final Map<String, FieldEntity> mFields = new HashMap<>();

    public ClassEntity (TypeElement element) {
        mElement = element;
        mSimpleName = element.getSimpleName().toString();
    }

    public void addFieldEntity(FieldEntity entity) {
        String fieldName = entity.getElement().toString();
        if (mFields.get(fieldName) == null) {
            mFields.put(fieldName, entity);
        }
    }

    public String getClassSimpleName() {
        return mSimpleName;
    }

    public TypeElement getElement() {
        return mElement;
    }

    public Map<String, FieldEntity> getFields () {
        return mFields;
    }

}
