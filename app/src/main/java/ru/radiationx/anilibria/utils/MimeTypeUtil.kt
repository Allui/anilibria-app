package ru.radiationx.anilibria.utils

/**
 * Created by radiationx on 23.05.17.
 */

object MimeTypeUtil {

    private val types by lazy {
        mutableMapOf(
                "323" to "text/h323",
                "3g2" to "video/3gpp2",
                "3gp" to "video/3gpp",
                "3gp2" to "video/3gpp2",
                "3gpp" to "video/3gpp",
                "7z" to "application/x-7z-compressed",
                "aa" to "audio/audible",
                "AAC" to "audio/aac",
                "aaf" to "application/octet-stream",
                "aax" to "audio/vnd.audible.aax",
                "ac3" to "audio/ac3",
                "aca" to "application/octet-stream",
                "accda" to "application/msaccess.addin",
                "accdb" to "application/msaccess",
                "accdc" to "application/msaccess.cab",
                "accde" to "application/msaccess",
                "accdr" to "application/msaccess.runtime",
                "accdt" to "application/msaccess",
                "accdw" to "application/msaccess.webapplication",
                "accft" to "application/msaccess.ftemplate",
                "acx" to "application/internet-property-stream",
                "AddIn" to "text/xml",
                "ade" to "application/msaccess",
                "adobebridge" to "application/x-bridge-url",
                "adp" to "application/msaccess",
                "ADT" to "audio/vnd.dlna.adts",
                "ADTS" to "audio/aac",
                "afm" to "application/octet-stream",
                "ai" to "application/postscript",
                "aif" to "audio/aiff",
                "aifc" to "audio/aiff",
                "aiff" to "audio/aiff",
                "air" to "application/vnd.adobe.air-application-installer-package+zip",
                "amc" to "application/mpeg",
                "anx" to "application/annodex",
                "apk" to "application/vnd.android.package-archive",
                "application" to "application/x-ms-application",
                "art" to "image/x-jg",
                "asa" to "application/xml",
                "asax" to "application/xml",
                "ascx" to "application/xml",
                "asd" to "application/octet-stream",
                "asf" to "video/x-ms-asf",
                "ashx" to "application/xml",
                "asi" to "application/octet-stream",
                "asm" to "text/plain",
                "asmx" to "application/xml",
                "aspx" to "application/xml",
                "asr" to "video/x-ms-asf",
                "asx" to "video/x-ms-asf",
                "atom" to "application/atom+xml",
                "au" to "audio/basic",
                "avi" to "video/x-msvideo",
                "axa" to "audio/annodex",
                "axs" to "application/olescript",
                "axv" to "video/annodex",
                "bas" to "text/plain",
                "bcpio" to "application/x-bcpio",
                "bin" to "application/octet-stream",
                "bmp" to "image/bmp",
                "c" to "text/plain",
                "cab" to "application/octet-stream",
                "caf" to "audio/x-caf",
                "calx" to "application/vnd.ms-office.calx",
                "cat" to "application/vnd.ms-pki.seccat",
                "cc" to "text/plain",
                "cd" to "text/plain",
                "cdda" to "audio/aiff",
                "cdf" to "application/x-cdf",
                "cer" to "application/x-x509-ca-cert",
                "cfg" to "text/plain",
                "chm" to "application/octet-stream",
                "class" to "application/x-java-applet",
                "clp" to "application/x-msclip",
                "cmd" to "text/plain",
                "cmx" to "image/x-cmx",
                "cnf" to "text/plain",
                "cod" to "image/cis-cod",
                "config" to "application/xml",
                "contact" to "text/x-ms-contact",
                "coverage" to "application/xml",
                "cpio" to "application/x-cpio",
                "cpp" to "text/plain",
                "crd" to "application/x-mscardfile",
                "crl" to "application/pkix-crl",
                "crt" to "application/x-x509-ca-cert",
                "cs" to "text/plain",
                "csdproj" to "text/plain",
                "csh" to "application/x-csh",
                "csproj" to "text/plain",
                "css" to "text/css",
                "csv" to "text/csv",
                "cur" to "application/octet-stream",
                "cxx" to "text/plain",
                "dat" to "application/octet-stream",
                "datasource" to "application/xml",
                "dbproj" to "text/plain",
                "dcr" to "application/x-director",
                "def" to "text/plain",
                "deploy" to "application/octet-stream",
                "der" to "application/x-x509-ca-cert",
                "dgml" to "application/xml",
                "dib" to "image/bmp",
                "dif" to "video/x-dv",
                "dir" to "application/x-director",
                "disco" to "text/xml",
                "divx" to "video/divx",
                "dll" to "application/x-msdownload",
                "dll.config" to "text/xml",
                "dlm" to "text/dlm",
                "doc" to "application/msword",
                "docm" to "application/vnd.ms-word.document.macroEnabled.12",
                "docx" to "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "dot" to "application/msword",
                "dotm" to "application/vnd.ms-word.template.macroEnabled.12",
                "dotx" to "application/vnd.openxmlformats-officedocument.wordprocessingml.template",
                "dsp" to "application/octet-stream",
                "dsw" to "text/plain",
                "dtd" to "text/xml",
                "dtsConfig" to "text/xml",
                "dv" to "video/x-dv",
                "dvi" to "application/x-dvi",
                "dwf" to "drawing/x-dwf",
                "dwp" to "application/octet-stream",
                "dxr" to "application/x-director",
                "eml" to "message/rfc822",
                "emz" to "application/octet-stream",
                "eot" to "application/vnd.ms-fontobject",
                "eps" to "application/postscript",
                "etl" to "application/etl",
                "etx" to "text/x-setext",
                "evy" to "application/envoy",
                "exe" to "application/octet-stream",
                "exe.config" to "text/xml",
                "fdf" to "application/vnd.fdf",
                "fif" to "application/fractals",
                "filters" to "application/xml",
                "fla" to "application/octet-stream",
                "flac" to "audio/flac",
                "flr" to "x-world/x-vrml",
                "flv" to "video/x-flv",
                "fsscript" to "application/fsharp-script",
                "fsx" to "application/fsharp-script",
                "generictest" to "application/xml",
                "gif" to "image/gif",
                "group" to "text/x-ms-group",
                "gsm" to "audio/x-gsm",
                "gtar" to "application/x-gtar",
                "gz" to "application/x-gzip",
                "h" to "text/plain",
                "hdf" to "application/x-hdf",
                "hdml" to "text/x-hdml",
                "hhc" to "application/x-oleobject",
                "hhk" to "application/octet-stream",
                "hhp" to "application/octet-stream",
                "hlp" to "application/winhlp",
                "hpp" to "text/plain",
                "hqx" to "application/mac-binhex40",
                "hta" to "application/hta",
                "htc" to "text/x-component",
                "htm" to "text/html",
                "html" to "text/html",
                "htt" to "text/webviewhtml",
                "hxa" to "application/xml",
                "hxc" to "application/xml",
                "hxd" to "application/octet-stream",
                "hxe" to "application/xml",
                "hxf" to "application/xml",
                "hxh" to "application/octet-stream",
                "hxi" to "application/octet-stream",
                "hxk" to "application/xml",
                "hxq" to "application/octet-stream",
                "hxr" to "application/octet-stream",
                "hxs" to "application/octet-stream",
                "hxt" to "text/html",
                "hxv" to "application/xml",
                "hxw" to "application/octet-stream",
                "hxx" to "text/plain",
                "i" to "text/plain",
                "ico" to "image/x-icon",
                "ics" to "application/octet-stream",
                "idl" to "text/plain",
                "ief" to "image/ief",
                "iii" to "application/x-iphone",
                "inc" to "text/plain",
                "inf" to "application/octet-stream",
                "ini" to "text/plain",
                "inl" to "text/plain",
                "ins" to "application/x-internet-signup",
                "ipa" to "application/x-itunes-ipa",
                "ipg" to "application/x-itunes-ipg",
                "ipproj" to "text/plain",
                "ipsw" to "application/x-itunes-ipsw",
                "iqy" to "text/x-ms-iqy",
                "isp" to "application/x-internet-signup",
                "ite" to "application/x-itunes-ite",
                "itlp" to "application/x-itunes-itlp",
                "itms" to "application/x-itunes-itms",
                "itpc" to "application/x-itunes-itpc",
                "IVF" to "video/x-ivf",
                "jar" to "application/java-archive",
                "java" to "application/octet-stream",
                "jck" to "application/liquidmotion",
                "jcz" to "application/liquidmotion",
                "jfif" to "image/pjpeg",
                "jnlp" to "application/x-java-jnlp-file",
                "jpb" to "application/octet-stream",
                "jpe" to "image/jpeg",
                "jpeg" to "image/jpeg",
                "jpg" to "image/jpeg",
                "js" to "application/javascript",
                "json" to "application/json",
                "jsx" to "text/jscript",
                "jsxbin" to "text/plain",
                "latex" to "application/x-latex",
                "library-ms" to "application/windows-library+xml",
                "lit" to "application/x-ms-reader",
                "loadtest" to "application/xml",
                "lpk" to "application/octet-stream",
                "lsf" to "video/x-la-asf",
                "lst" to "text/plain",
                "lsx" to "video/x-la-asf",
                "lzh" to "application/octet-stream",
                "m13" to "application/x-msmediaview",
                "m14" to "application/x-msmediaview",
                "m1v" to "video/mpeg",
                "m2t" to "video/vnd.dlna.mpeg-tts",
                "m2ts" to "video/vnd.dlna.mpeg-tts",
                "m2v" to "video/mpeg",
                "m3u" to "audio/x-mpegurl",
                "m3u8" to "audio/x-mpegurl",
                "m4a" to "audio/m4a",
                "m4b" to "audio/m4b",
                "m4p" to "audio/m4p",
                "m4r" to "audio/x-m4r",
                "m4v" to "video/x-m4v",
                "mac" to "image/x-macpaint",
                "mak" to "text/plain",
                "man" to "application/x-troff-man",
                "manifest" to "application/x-ms-manifest",
                "map" to "text/plain",
                "master" to "application/xml",
                "mda" to "application/msaccess",
                "mdb" to "application/x-msaccess",
                "mde" to "application/msaccess",
                "mdp" to "application/octet-stream",
                "me" to "application/x-troff-me",
                "mfp" to "application/x-shockwave-flash",
                "mht" to "message/rfc822",
                "mhtml" to "message/rfc822",
                "mid" to "audio/mid",
                "midi" to "audio/mid",
                "mix" to "application/octet-stream",
                "mk" to "text/plain",
                "mmf" to "application/x-smaf",
                "mno" to "text/xml",
                "mny" to "application/x-msmoney",
                "mod" to "video/mpeg",
                "mov" to "video/quicktime",
                "movie" to "video/x-sgi-movie",
                "mp2" to "video/mpeg",
                "mp2v" to "video/mpeg",
                "mp3" to "audio/mpeg",
                "mp4" to "video/mp4",
                "mp4v" to "video/mp4",
                "mpa" to "video/mpeg",
                "mpe" to "video/mpeg",
                "mpeg" to "video/mpeg",
                "mpf" to "application/vnd.ms-mediapackage",
                "mpg" to "video/mpeg",
                "mpp" to "application/vnd.ms-project",
                "mpv2" to "video/mpeg",
                "mqv" to "video/quicktime",
                "ms" to "application/x-troff-ms",
                "msi" to "application/octet-stream",
                "mso" to "application/octet-stream",
                "mts" to "video/vnd.dlna.mpeg-tts",
                "mtx" to "application/xml",
                "mvb" to "application/x-msmediaview",
                "mvc" to "application/x-miva-compiled",
                "mxp" to "application/x-mmxp",
                "nc" to "application/x-netcdf",
                "nsc" to "video/x-ms-asf",
                "nws" to "message/rfc822",
                "ocx" to "application/octet-stream",
                "oda" to "application/oda",
                "odb" to "application/vnd.oasis.opendocument.database",
                "odc" to "application/vnd.oasis.opendocument.chart",
                "odf" to "application/vnd.oasis.opendocument.formula",
                "odg" to "application/vnd.oasis.opendocument.graphics",
                "odh" to "text/plain",
                "odi" to "application/vnd.oasis.opendocument.image",
                "odl" to "text/plain",
                "odm" to "application/vnd.oasis.opendocument.text-master",
                "odp" to "application/vnd.oasis.opendocument.presentation",
                "ods" to "application/vnd.oasis.opendocument.spreadsheet",
                "odt" to "application/vnd.oasis.opendocument.text",
                "oga" to "audio/ogg",
                "ogg" to "audio/ogg",
                "ogv" to "video/ogg",
                "ogx" to "application/ogg",
                "one" to "application/onenote",
                "onea" to "application/onenote",
                "onepkg" to "application/onenote",
                "onetmp" to "application/onenote",
                "onetoc" to "application/onenote",
                "onetoc2" to "application/onenote",
                "opus" to "audio/ogg",
                "orderedtest" to "application/xml",
                "osdx" to "application/opensearchdescription+xml",
                "otf" to "application/font-sfnt",
                "otg" to "application/vnd.oasis.opendocument.graphics-template",
                "oth" to "application/vnd.oasis.opendocument.text-web",
                "otp" to "application/vnd.oasis.opendocument.presentation-template",
                "ots" to "application/vnd.oasis.opendocument.spreadsheet-template",
                "ott" to "application/vnd.oasis.opendocument.text-template",
                "oxt" to "application/vnd.openofficeorg.extension",
                "p10" to "application/pkcs10",
                "p12" to "application/x-pkcs12",
                "p7b" to "application/x-pkcs7-certificates",
                "p7c" to "application/pkcs7-mime",
                "p7m" to "application/pkcs7-mime",
                "p7r" to "application/x-pkcs7-certreqresp",
                "p7s" to "application/pkcs7-signature",
                "pbm" to "image/x-portable-bitmap",
                "pcast" to "application/x-podcast",
                "pct" to "image/pict",
                "pcx" to "application/octet-stream",
                "pcz" to "application/octet-stream",
                "pdf" to "application/pdf",
                "pfb" to "application/octet-stream",
                "pfm" to "application/octet-stream",
                "pfx" to "application/x-pkcs12",
                "pgm" to "image/x-portable-graymap",
                "pic" to "image/pict",
                "pict" to "image/pict",
                "pkgdef" to "text/plain",
                "pkgundef" to "text/plain",
                "pko" to "application/vnd.ms-pki.pko",
                "pls" to "audio/scpls",
                "pma" to "application/x-perfmon",
                "pmc" to "application/x-perfmon",
                "pml" to "application/x-perfmon",
                "pmr" to "application/x-perfmon",
                "pmw" to "application/x-perfmon",
                "png" to "image/png",
                "pnm" to "image/x-portable-anymap",
                "pnt" to "image/x-macpaint",
                "pntg" to "image/x-macpaint",
                "pnz" to "image/png",
                "pot" to "application/vnd.ms-powerpoint",
                "potm" to "application/vnd.ms-powerpoint.template.macroEnabled.12",
                "potx" to "application/vnd.openxmlformats-officedocument.presentationml.template",
                "ppa" to "application/vnd.ms-powerpoint",
                "ppam" to "application/vnd.ms-powerpoint.addin.macroEnabled.12",
                "ppm" to "image/x-portable-pixmap",
                "pps" to "application/vnd.ms-powerpoint",
                "ppsm" to "application/vnd.ms-powerpoint.slideshow.macroEnabled.12",
                "ppsx" to "application/vnd.openxmlformats-officedocument.presentationml.slideshow",
                "ppt" to "application/vnd.ms-powerpoint",
                "pptm" to "application/vnd.ms-powerpoint.presentation.macroEnabled.12",
                "pptx" to "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                "prf" to "application/pics-rules",
                "prm" to "application/octet-stream",
                "prx" to "application/octet-stream",
                "ps" to "application/postscript",
                "psc1" to "application/PowerShell",
                "psd" to "application/octet-stream",
                "psess" to "application/xml",
                "psm" to "application/octet-stream",
                "psp" to "application/octet-stream",
                "pub" to "application/x-mspublisher",
                "pwz" to "application/vnd.ms-powerpoint",
                "qht" to "text/x-html-insertion",
                "qhtm" to "text/x-html-insertion",
                "qt" to "video/quicktime",
                "qti" to "image/x-quicktime",
                "qtif" to "image/x-quicktime",
                "qtl" to "application/x-quicktimeplayer",
                "qxd" to "application/octet-stream",
                "ra" to "audio/x-pn-realaudio",
                "ram" to "audio/x-pn-realaudio",
                "rar" to "application/x-rar-compressed",
                "ras" to "image/x-cmu-raster",
                "rat" to "application/rat-file",
                "rc" to "text/plain",
                "rc2" to "text/plain",
                "rct" to "text/plain",
                "rdlc" to "application/xml",
                "reg" to "text/plain",
                "resx" to "application/xml",
                "rf" to "image/vnd.rn-realflash",
                "rgb" to "image/x-rgb",
                "rgs" to "text/plain",
                "rm" to "application/vnd.rn-realmedia",
                "rmi" to "audio/mid",
                "rmp" to "application/vnd.rn-rn_music_package",
                "roff" to "application/x-troff",
                "rpm" to "audio/x-pn-realaudio-plugin",
                "rqy" to "text/x-ms-rqy",
                "rtf" to "application/rtf",
                "rtx" to "text/richtext",
                "ruleset" to "application/xml",
                "s" to "text/plain",
                "safariextz" to "application/x-safari-safariextz",
                "scd" to "application/x-msschedule",
                "scr" to "text/plain",
                "sct" to "text/scriptlet",
                "sd2" to "audio/x-sd2",
                "sdp" to "application/sdp",
                "sea" to "application/octet-stream",
                "searchConnector-ms" to "application/windows-search-connector+xml",
                "setpay" to "application/set-payment-initiation",
                "setreg" to "application/set-registration-initiation",
                "settings" to "application/xml",
                "sgimb" to "application/x-sgimb",
                "sgml" to "text/sgml",
                "sh" to "application/x-sh",
                "shar" to "application/x-shar",
                "shtml" to "text/html",
                "sit" to "application/x-stuffit",
                "sitemap" to "application/xml",
                "skin" to "application/xml",
                "sldm" to "application/vnd.ms-powerpoint.slide.macroEnabled.12",
                "sldx" to "application/vnd.openxmlformats-officedocument.presentationml.slide",
                "slk" to "application/vnd.ms-excel",
                "sln" to "text/plain",
                "slupkg-ms" to "application/x-ms-license",
                "smd" to "audio/x-smd",
                "smi" to "application/octet-stream",
                "smx" to "audio/x-smd",
                "smz" to "audio/x-smd",
                "snd" to "audio/basic",
                "snippet" to "application/xml",
                "snp" to "application/octet-stream",
                "sol" to "text/plain",
                "sor" to "text/plain",
                "spc" to "application/x-pkcs7-certificates",
                "spl" to "application/futuresplash",
                "spx" to "audio/ogg",
                "src" to "application/x-wais-source",
                "srf" to "text/plain",
                "SSISDeploymentManifest" to "text/xml",
                "ssm" to "application/streamingmedia",
                "sst" to "application/vnd.ms-pki.certstore",
                "stl" to "application/vnd.ms-pki.stl",
                "sv4cpio" to "application/x-sv4cpio",
                "sv4crc" to "application/x-sv4crc",
                "svc" to "application/xml",
                "svg" to "image/svg+xml",
                "swf" to "application/x-shockwave-flash",
                "t" to "application/x-troff",
                "tar" to "application/x-tar",
                "tcl" to "application/x-tcl",
                "testrunconfig" to "application/xml",
                "testsettings" to "application/xml",
                "tex" to "application/x-tex",
                "texi" to "application/x-texinfo",
                "texinfo" to "application/x-texinfo",
                "tgz" to "application/x-compressed",
                "thmx" to "application/vnd.ms-officetheme",
                "thn" to "application/octet-stream",
                "tif" to "image/tiff",
                "tiff" to "image/tiff",
                "tlh" to "text/plain",
                "tli" to "text/plain",
                "toc" to "application/octet-stream",
                "tr" to "application/x-troff",
                "trm" to "application/x-msterminal",
                "trx" to "application/xml",
                "ts" to "video/vnd.dlna.mpeg-tts",
                "tsv" to "text/tab-separated-values",
                "ttf" to "application/font-sfnt",
                "tts" to "video/vnd.dlna.mpeg-tts",
                "txt" to "text/plain",
                "u32" to "application/octet-stream",
                "uls" to "text/iuls",
                "user" to "text/plain",
                "ustar" to "application/x-ustar",
                "vb" to "text/plain",
                "vbdproj" to "text/plain",
                "vbk" to "video/mpeg",
                "vbproj" to "text/plain",
                "vbs" to "text/vbscript",
                "vcf" to "text/x-vcard",
                "vcproj" to "application/xml",
                "vcs" to "text/plain",
                "vcxproj" to "application/xml",
                "vddproj" to "text/plain",
                "vdp" to "text/plain",
                "vdproj" to "text/plain",
                "vdx" to "application/vnd.ms-visio.viewer",
                "vml" to "text/xml",
                "vscontent" to "application/xml",
                "vsct" to "text/xml",
                "vsd" to "application/vnd.visio",
                "vsi" to "application/ms-vsi",
                "vsix" to "application/vsix",
                "vsixlangpack" to "text/xml",
                "vsixmanifest" to "text/xml",
                "vsmdi" to "application/xml",
                "vspscc" to "text/plain",
                "vss" to "application/vnd.visio",
                "vsscc" to "text/plain",
                "vssettings" to "text/xml",
                "vssscc" to "text/plain",
                "vst" to "application/vnd.visio",
                "vstemplate" to "text/xml",
                "vsto" to "application/x-ms-vsto",
                "vsw" to "application/vnd.visio",
                "vsx" to "application/vnd.visio",
                "vtx" to "application/vnd.visio",
                "wav" to "audio/wav",
                "wave" to "audio/wav",
                "wax" to "audio/x-ms-wax",
                "wbk" to "application/msword",
                "wbmp" to "image/vnd.wap.wbmp",
                "wcm" to "application/vnd.ms-works",
                "wdb" to "application/vnd.ms-works",
                "wdp" to "image/vnd.ms-photo",
                "webarchive" to "application/x-safari-webarchive",
                "webm" to "video/webm",
                "webp" to "image/webp",
                "webtest" to "application/xml",
                "wiq" to "application/xml",
                "wiz" to "application/msword",
                "wks" to "application/vnd.ms-works",
                "WLMP" to "application/wlmoviemaker",
                "wlpginstall" to "application/x-wlpg-detect",
                "wlpginstall3" to "application/x-wlpg3-detect",
                "wm" to "video/x-ms-wm",
                "wma" to "audio/x-ms-wma",
                "wmd" to "application/x-ms-wmd",
                "wmf" to "application/x-msmetafile",
                "wml" to "text/vnd.wap.wml",
                "wmlc" to "application/vnd.wap.wmlc",
                "wmls" to "text/vnd.wap.wmlscript",
                "wmlsc" to "application/vnd.wap.wmlscriptc",
                "wmp" to "video/x-ms-wmp",
                "wmv" to "video/x-ms-wmv",
                "wmx" to "video/x-ms-wmx",
                "wmz" to "application/x-ms-wmz",
                "woff" to "application/font-woff",
                "wpl" to "application/vnd.ms-wpl",
                "wps" to "application/vnd.ms-works",
                "wri" to "application/x-mswrite",
                "wrl" to "x-world/x-vrml",
                "wrz" to "x-world/x-vrml",
                "wsc" to "text/scriptlet",
                "wsdl" to "text/xml",
                "wvx" to "video/x-ms-wvx",
                "x" to "application/directx",
                "xaf" to "x-world/x-vrml",
                "xaml" to "application/xaml+xml",
                "xap" to "application/x-silverlight-app",
                "xbap" to "application/x-ms-xbap",
                "xbm" to "image/x-xbitmap",
                "xdr" to "text/plain",
                "xht" to "application/xhtml+xml",
                "xhtml" to "application/xhtml+xml",
                "xla" to "application/vnd.ms-excel",
                "xlam" to "application/vnd.ms-excel.addin.macroEnabled.12",
                "xlc" to "application/vnd.ms-excel",
                "xld" to "application/vnd.ms-excel",
                "xlk" to "application/vnd.ms-excel",
                "xll" to "application/vnd.ms-excel",
                "xlm" to "application/vnd.ms-excel",
                "xls" to "application/vnd.ms-excel",
                "xlsb" to "application/vnd.ms-excel.sheet.binary.macroEnabled.12",
                "xlsm" to "application/vnd.ms-excel.sheet.macroEnabled.12",
                "xlsx" to "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                "xlt" to "application/vnd.ms-excel",
                "xltm" to "application/vnd.ms-excel.template.macroEnabled.12",
                "xltx" to "application/vnd.openxmlformats-officedocument.spreadsheetml.template",
                "xlw" to "application/vnd.ms-excel",
                "xml" to "text/xml",
                "xmta" to "application/xml",
                "xof" to "x-world/x-vrml",
                "XOML" to "text/plain",
                "xpm" to "image/x-xpixmap",
                "xps" to "application/vnd.ms-xpsdocument",
                "xrm-ms" to "text/xml",
                "xsc" to "application/xml",
                "xsd" to "text/xml",
                "xsf" to "text/xml",
                "xsl" to "text/xml",
                "xslt" to "text/xml",
                "xsn" to "application/octet-stream",
                "xss" to "application/xml",
                "xspf" to "application/xspf+xml",
                "xtp" to "application/octet-stream",
                "xwd" to "image/x-xwindowdump",
                "z" to "application/x-compress",
                "zip" to "application/zip"
        )
    }


    fun getType(nameOrExtension: String): String? = types[getExtension(nameOrExtension)]

    fun getExtension(name: String): String {
        val cut = name.lastIndexOf('.')
        if (cut != -1) {
            return name.substring(cut + 1)
        }
        return name
    }

    fun isImage(nameOrExtension: String): Boolean {
        val type = getType(nameOrExtension) ?: return false
        return type.contains("image/")
    }
}
