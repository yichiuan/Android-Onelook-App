package com.yichiuan.onelook.data.remote.model;

import com.google.auto.value.AutoValue;
import com.tickaroo.tikxml.annotation.TextContent;
import com.tickaroo.tikxml.annotation.Xml;


@Xml
@AutoValue
public abstract class OLQuickDef {
    @TextContent
    public abstract String quickDef();
}

