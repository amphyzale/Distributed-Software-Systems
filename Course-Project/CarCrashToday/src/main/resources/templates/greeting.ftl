<#import "parts/common.ftl" as c>
<#include "parts/security.ftl" >

<@c.page>
    <#if currentUserId == -1>
        <h5>Приветствуем Вас на нашем сайте!</h5>
    <#else >
        <h5>Приветствуем на нашем сайте, ${name}!</h5>
    </#if>
    <p>//TODO</p>


    <div>
        <style>.ya-news__title{font-size:100%;font-weight:700;margin-bottom:.5em}
            .ya-news__date{font-size:85%;margin-right:.5em}
            .ya-news__informer{font-size:85%;margin-bottom:.3em}
            .ya-news__description{font-size:85%;margin-bottom:.5em}
            .ya-news__all{font-size:80%;margin-top:.3em}</style>
        <script src="https://news.yandex.ru/ru/auto5.utf8.js" charset="utf-8"></script>
        <script>(function(w,rubric){var data=w[rubric];if(!data||!data.length){return;}
                function formatDate(ts){var d=new Date(ts*1000);return d.getHours()+':'+('0'+d.getMinutes()).substr(-2);}
                var html='<div class="ya-news__title"><a href="https://news.yandex.ru/" target="_blank">Новости</a></div>' +
                    '';for(var i=0;i<data.length;i++){var item=data[i];html
                    +='<div><span class="ya-news__date">'+item.date+'&nbsp;'+item.time+'</span>' +
                    '<span class="ya-news__title"><a href="'+item.url+'" target="_blank">'+item.title+'</a></span>' +
                    '</div><div class="ya-news__description">'+item.descr+'</div>';}html+='<div class="ya-news__all">' +
                    '<a href="https://news.yandex.ru/" target="_blank">Все новости на '+formatDate(w.update_time_t)+'</a>' +
                    '</div>';document.write(html);}(window, 'm_auto'));</script>
    </div>

</@c.page>