<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        isModerator = user.isModerator()
        currentUserId = user.getId()
    >
<#else >
    <#assign
        name = "Гость"
        isAdmin = false
        isModerator = false
        currentUserId = -1
    >
</#if>