package com.garlicholic.backend.domain.mail;

public class ReportTemplateGenerator {

    public static String generate(ReportMailData mailData) {
        return """
                 <div class=""><div class="aHl"></div><div id=":29" tabindex="-1"></div><div id=":1z" class="ii gt" jslog="20277; u014N:xr6bB; 1:WyIjdGhyZWFkLWY6MTgyNTA3ODAxNDA1ODczNDgwOCJd; 4:WyIjbXNnLWY6MTgyNTA3ODEyMjczNTU3ODQ0NCIsbnVsbCxudWxsLG51bGwsMiwxLFsxLDAsMF0sMzYsMTk2LG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCwxLG51bGwsbnVsbCxbMF0sbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsMCwwXQ.."><div id=":1y" class="a3s aiL "><u></u>
                
                 <div>
                     <table width="100%%" cellspacing="0" cellpadding="0" border="0" align="center" bgcolor="#efeff0" style="border-collapse:collapse">
                         <tbody>
                         <tr>
                             <td>
                
                                 <table width="100%%" cellspacing="0" cellpadding="0" border="0" align="center" bgcolor="#ffffff" style="max-width:640px;margin:0 auto">
                                     <tbody>
                                     <tr>
                                         <td width="100%%" height="45" colspan="3" bgcolor="#EDDECE"></td>
                                     </tr>
                                     <tr>
                                         <td width="2%%" height="25" bgcolor="#EDDECE"></td>
                                         <td width="88%%" height="25" bgcolor="#EDDECE">
                                             <img src="cid:banner" width="960" height="200" alt="나마늘기억해" border="0" style="display:block" data-image-whitelisted="" class="CToWUd" data-bit="iit" />
                                         </td>
                                         <td width="2%%" height="25" bgcolor="#EDDECE"></td>
                                     </tr>
                                     <tr>
                                         <td width="100%%" height="45" colspan="3" bgcolor="#EDDECE"></td>
                                     </tr>
                                     <tr>
                                         <td width="100%%" height="35" colspan="3"></td>
                                     </tr>
                
                                         <tr>
                         <td width="2%%"></td>
                         <td width="88%%" style="font-size:18px;line-height:22px;font-family:Apple SD Gothic Neo,sans-serif,'\\00b9d1\\00c740\\00ace0\\00b515',Malgun Gothic,'\\00ad74\\00b9bc',gulim;letter-spacing:-1px;font-weight:bold;color:#1e1e1e">📑 일간 건강 리포트를 공유드려요!</td>
                         <td width="2%%"></td>
                     </tr>
                     <tr>
                         <td width="100%%" height="25" colspan="3"></td>
                     </tr>
                     <tr>
                         <td width="2%%"></td>
                         <td width="88%%" style="font-size:14px;line-height:22px;font-family:Apple SD Gothic Neo,sans-serif,'\\00b9d1\\00c740\\00ace0\\00b515',Malgun Gothic,'\\00ad74\\00b9bc',gulim;letter-spacing:-1px;color:#1e1e1e">%s 기준 건강 정보를 정리했어요.</td>
                         <td width="2%%"></td>
                     </tr>
                     <tr>
                         <td width="100%%" height="18" colspan="3"></td>
                     </tr>
                     <tr>
                         <td width="2%%"></td>
                         <td width="88%%">
                             <table width="100%%" cellspacing="0" cellpadding="0" border="0" style="line-height:22px;font-family:Apple SD Gothic Neo,sans-serif,'\\00b9d1\\00c740\\00ace0\\00b515',Malgun Gothic,'\\00ad74\\00b9bc',gulim;letter-spacing:-1px;color:#1e1e1e">
                                 <tbody>
                                 <tr>
                                     <td width="100%%" height="1" colspan="5" bgcolor="#bebebe"></td>
                                 </tr>
                                 <tr>
                                     <td width="100%%" height="25" colspan="5"></td>
                                 </tr>
                                 <tr>
                                     <td width="2%%"></td>
                                     <th width="22%%" valign="top" align="left" style="font-size:14px;font-weight:normal">치매 여부</th>
                                     <td width="2%%"></td>
                                     <td width="70%%" valign="top" style="font-size:14px;font-weight:bold;word-break:break-all">%s</td>
                                     <td width="2%%"></td>
                                 </tr>
                                 <tr>
                                     <td width="100%%" height="8" colspan="5"></td>
                                 </tr>
                                 <tr>
                                     <td width="2%%"></td>
                                     <th width="22%%" valign="top" align="left" style="font-size:14px;font-weight:normal">진단 사유</th>
                                     <td width="2%%"></td>
                                     <td width="70%%" valign="top" style="font-size:14px;font-weight:bold;word-break:break-all">%s</td>
                                     <td width="2%%"></td>
                                 </tr>
                                 <tr>
                                     <td width="100%%" height="27" colspan="5"></td>
                                 </tr>
                                 <tr>
                                     <td width="100%%" height="1" colspan="5" bgcolor="#bebebe"></td>
                                 </tr>
                                 </tbody>
                             </table>
                         </td>
                         <td width="2%%"></td>
                     </tr>
                     <tr>
                         <td width="100%%" height="58" colspan="3"></td>
                     </tr>
                
                
                                     <tr>
                                         <td width="100%%" height="1" colspan="3" bgcolor="#e6e6e6"></td>
                                     </tr>
                                     <tr>
                                         <td width="100%%" height="16" colspan="3"></td>
                                     </tr>
                                     <tr>
                                         <td width="2%%"></td>
                                         <td width="88%%" style="font-size:12px;line-height:18px;font-family:Apple SD Gothic Neo,sans-serif,'\\00b9d1\\00c740\\00ace0\\00b515',Malgun Gothic,'\\00b3cb\\00c6c0',Dotum;letter-spacing:-1px;color:#767676">
                                             본 메일은 발신전용입니다.
                                             Copyright © <a href="https://www.kakaocorp.com/" style="color:#767676;text-decoration:none" target="_blank" data-saferedirecturl="https://www.google.com/url?q=https://www.kakaocorp.com/&amp;source=gmail&amp;ust=1751118237982000&amp;usg=AOvVaw02hIr2qt6V2VPPrTxsXlPP">GarlicHolic Team.</a>
                                             All rights reserved.
                                         </td>
                                         <td width="2%%"></td>
                                     </tr>
                                     <tr>
                                         <td width="100%%" height="18" colspan="3"></td>
                                     </tr>
                
                                     </tbody>
                                 </table>
                             </td>
                         </tr>
                         <tr>
                             <td width="100%%" height="100"></td>
                         </tr>
                         </tbody>
                     </table><div class="yj6qo"></div><div class="adL">
                 </div></div><div class="adL">
                 </div></div></div><div class="WhmR8e" data-hash="0"></div></div>
                """.formatted(
                mailData.getTargetDateText(),
                mailData.getDementiaStatusText(),
                mailData.getDiagnosisReasonText()
        );
    }

}
