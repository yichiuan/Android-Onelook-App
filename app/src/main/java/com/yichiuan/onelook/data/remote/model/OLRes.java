package com.yichiuan.onelook.data.remote.model;

import com.google.auto.value.AutoValue;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;


@Xml
@AutoValue
public abstract class OLRes {
    @PropertyElement(name = "OLResName")
    public abstract String dictionary();

    @PropertyElement(name = "OLResLink")
    public abstract String link();

    @PropertyElement(name = "OLResHomeLink")
    public abstract String dictionaryHomeLink();
}