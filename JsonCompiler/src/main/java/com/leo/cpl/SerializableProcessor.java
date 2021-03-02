package com.leo.cpl;

import com.leo.ann.Serializable;

import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

public class SerializableProcessor extends AbstractProcessor {

    private Elements mElementUtils;
    private Filer mFiler;
    private Messager mMessager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mElementUtils = processingEnvironment.getElementUtils();
        mFiler = processingEnvironment.getFiler();
        mMessager = processingEnvironment.getMessager();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Serializable.class.getCanonicalName());
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends  Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(Serializable.class);
        for (Element element : elementsAnnotatedWith) {
            if (element.getKind() == ElementKind.FIELD) {
                handleField((VariableElement) element);
            }

            if (element.getKind() == ElementKind.CLASS) {
                handleClass((TypeElement) element);
            }
        }
        return true;
    }

    private void handleField(VariableElement element) {

    }

    private void handleClass(TypeElement element) {

    }
}