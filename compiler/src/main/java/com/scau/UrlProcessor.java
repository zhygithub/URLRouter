package com.scau;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

/**
 * Created by ZhengHy on 2016/10/6 0006.
 */
@SupportedAnnotationTypes("com.scau.UrlBinding")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class UrlProcessor extends AbstractProcessor {

    private final String pakName = "URLMap";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Elements elementUtils = processingEnv.getElementUtils();
        Messager messager = processingEnv.getMessager();

        messager.printMessage(Diagnostic.Kind.NOTE, "i am in here");

        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(UrlBinding.class);

        TypeSpec.Builder builder = TypeSpec.classBuilder("BaseMap" + "$SUFFIX")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

        FieldSpec map = FieldSpec.builder(HashMap.class,"baseRouterMap").addModifiers(Modifier.FINAL,Modifier.PUBLIC,Modifier.STATIC)
                .initializer("new HashMap<$T,$T>()",String.class,String.class).build();

        builder.addField(map);

        CodeBlock.Builder staticCodeBlock = CodeBlock.builder();

        UrlBinding annotation;
        Element enclosingElement;
        String enclosingQualifiedName;
        for (Element element : elements
                ) {

            annotation = element.getAnnotation(UrlBinding.class);

            staticCodeBlock.addStatement("baseRouterMap.put($S,$S)",annotation.url(),annotation.controller());


            enclosingElement = element.getEnclosingElement();


            if (enclosingElement instanceof PackageElement) {
                enclosingQualifiedName = ((PackageElement) enclosingElement).getQualifiedName().toString();
            } else {
                enclosingQualifiedName = ((TypeElement) enclosingElement).getQualifiedName().toString();
            }

            String pakgeName = enclosingQualifiedName.substring(0, enclosingQualifiedName.lastIndexOf('.'));

            String simpleName = element.getSimpleName().toString();

            messager.printMessage(Diagnostic.Kind.NOTE, "simpleName : "+simpleName +" ,annotation.url() = "+annotation.url());



            FieldSpec str = FieldSpec.builder(String.class,simpleName+"_Activity").addModifiers(Modifier.FINAL,Modifier.PUBLIC,Modifier.STATIC)
                    .initializer("$S",annotation.controller()).build();



            builder.addField(str);


        }

        builder.addStaticBlock(staticCodeBlock.build());


        MethodSpec getRouterMap = MethodSpec.methodBuilder("getRouterMap")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(HashMap.class)
                .addStatement("return baseRouterMap")
                .build();

        builder.addMethod(getRouterMap);

        TypeSpec helloWorld = builder.build();


        JavaFile javaFile = JavaFile.builder(pakName + ".network.scau.com.urlrouter.map", helloWorld).build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}
