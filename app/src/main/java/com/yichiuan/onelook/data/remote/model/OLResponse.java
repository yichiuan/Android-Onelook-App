package com.yichiuan.onelook.data.remote.model;

import com.google.auto.value.AutoValue;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;


@Xml
@AutoValue
public abstract class OLResponse {

    // workaround because @PropertyElement for list isn't available until v1.0
    // https://github.com/Tickaroo/tikxml/issues/46
    @Element(name = "OLQuickDef")
    public abstract List<OLQuickDef> quickDefs();

    @Element(name = "OLRes")
    public abstract List<OLRes> resList();

    @PropertyElement(name = "OLPhrases")
    public abstract String phrases();

    @PropertyElement(name = "OLSimilar")
    public abstract String similar();
}
