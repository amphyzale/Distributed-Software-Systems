<#import "parts/common.ftl" as c>
<#include "parts/security.ftl" >

<@c.page>
    <#if isCurrentUser || isAdmin>
        <#include "parts/messageEdit.ftl" />
    </#if>
    <#include "parts/newsList.ftl" />
</@c.page>