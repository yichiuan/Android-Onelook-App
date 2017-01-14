package com.yichiuan.onelook.data.remote.model;

import android.support.annotation.Nullable;

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
    @Nullable
    @Element(name = "OLQuickDef")
    public abstract List<OLQuickDef> quickDefs();

    @Nullable
    @PropertyElement(name = "OLQuickDefLemma")
    public abstract String quickDefLemma();

    @Nullable
    @Element(name = "OLRes")
    public abstract List<OLRes> resList();

    @Nullable
    @PropertyElement(name = "OLPhrases")
    public abstract String phrases();

    @Nullable
    @PropertyElement(name = "OLSimilar")
    public abstract String similar();
}
