<#import "parts/common.ftl" as c>
<@c.page>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>
</div>
<#else>
Mo messages
</#list>
</@c.page>
