# Postal Code TW 郵遞區號

## 臺灣郵遞區號3碼對應縣市區

資料來源：https://www.post.gov.tw/post/internet/Download/index.jsp?ID=2292

### postalCode.java

|ArrayList|描述|
|-|-|
|code_city_area_raw|原始資料取郵遞區號前3碼、縣市名稱、鄉鎮市區，以逗號分隔|
|code_city_area|去除 code_city_area_raw 中重複的資料|
|code3_city_area|將 code_city_area 存成二維 ArrayList：[`郵遞區號前3碼`, `縣市名稱`, `鄉鎮市區`]|
|code3_city|二維 ArrayList：[`郵遞區號前3碼`, `縣市名稱`]|
|code3_city_area_taipei|二維 ArrayList：[`郵遞區號前3碼`, 臺北市, `區名稱]`|
|code3_city_area_newtaipei|二維 ArrayList：[`郵遞區號前3碼`, `新北市`, `區名稱]`|


#### 組成 R 所需的 code：
|code|描述|
|-|-|
|code1|"`郵遞區號3碼`"="`縣市名稱`", "`郵遞區號3碼`"="`縣市名稱`", ...|
|code2|"`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", "`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", ...|
|code3|"`新北市的郵遞區號3碼`"="`區名稱`", "`新北市的郵遞區號3碼`"="`區名稱`", ...|


- code1
```
"100"="臺北市", "103"="臺北市", "104"="臺北市", "105"="臺北市", "106"="臺北市", "108"="臺北市", "110"="臺北市", "111"="臺北市", "112"="臺北市", "114"="臺北市", "115"="臺北市", "116"="臺北市", "200"="基隆市", "201"="基隆市", "202"="基隆市", "203"="基隆市", "204"="基隆市", "205"="基隆市", "206"="基隆市", "207"="新北市", "208"="新北市", "209"="連江縣", "210"="連江縣", "211"="連江縣", "212"="連江縣", "220"="新北市", "221"="新北市", "222"="新北市", "223"="新北市", "224"="新北市", "226"="新北市", "227"="新北市", "228"="新北市", "231"="新北市", "232"="新北市", "233"="新北市", "234"="新北市", "235"="新北市", "236"="新北市", "237"="新北市", "238"="新北市", "239"="新北市", "241"="新北市", "242"="新北市", "243"="新北市", "244"="新北市", "247"="新北市", "248"="新北市", "249"="新北市", "251"="新北市", "252"="新北市", "253"="新北市", "260"="宜蘭縣", "261"="宜蘭縣", "262"="宜蘭縣", "263"="宜蘭縣", "264"="宜蘭縣", "265"="宜蘭縣", "266"="宜蘭縣", "267"="宜蘭縣", "268"="宜蘭縣", "269"="宜蘭縣", "270"="宜蘭縣", "272"="宜蘭縣", "290"="宜蘭縣", "300"="新竹市", "302"="新竹縣", "303"="新竹縣", "304"="新竹縣", "305"="新竹縣", "306"="新竹縣", "307"="新竹縣", "308"="新竹縣", "310"="新竹縣", "311"="新竹縣", "312"="新竹縣", "313"="新竹縣", "314"="新竹縣", "315"="新竹縣", "320"="桃園市", "324"="桃園市", "325"="桃園市", "326"="桃園市", "327"="桃園市", "328"="桃園市", "330"="桃園市", "333"="桃園市", "334"="桃園市", "335"="桃園市", "336"="桃園市", "337"="桃園市", "338"="桃園市", "350"="苗栗縣", "351"="苗栗縣", "352"="苗栗縣", "353"="苗栗縣", "354"="苗栗縣", "356"="苗栗縣", "357"="苗栗縣", "358"="苗栗縣", "360"="苗栗縣", "361"="苗栗縣", "362"="苗栗縣", "363"="苗栗縣", "364"="苗栗縣", "365"="苗栗縣", "366"="苗栗縣", "367"="苗栗縣", "368"="苗栗縣", "369"="苗栗縣", "400"="臺中市", "401"="臺中市", "402"="臺中市", "403"="臺中市", "404"="臺中市", "406"="臺中市", "407"="臺中市", "408"="臺中市", "411"="臺中市", "412"="臺中市", "413"="臺中市", "414"="臺中市", "420"="臺中市", "421"="臺中市", "422"="臺中市", "423"="臺中市", "424"="臺中市", "426"="臺中市", "427"="臺中市", "428"="臺中市", "429"="臺中市", "432"="臺中市", "433"="臺中市", "434"="臺中市", "435"="臺中市", "436"="臺中市", "437"="臺中市", "438"="臺中市", "439"="臺中市", "500"="彰化縣", "502"="彰化縣", "503"="彰化縣", "504"="彰化縣", "505"="彰化縣", "506"="彰化縣", "507"="彰化縣", "508"="彰化縣", "509"="彰化縣", "510"="彰化縣", "511"="彰化縣", "512"="彰化縣", "513"="彰化縣", "514"="彰化縣", "515"="彰化縣", "516"="彰化縣", "520"="彰化縣", "521"="彰化縣", "522"="彰化縣", "523"="彰化縣", "524"="彰化縣", "525"="彰化縣", "526"="彰化縣", "527"="彰化縣", "528"="彰化縣", "530"="彰化縣", "540"="南投縣", "541"="南投縣", "542"="南投縣", "544"="南投縣", "545"="南投縣", "546"="南投縣", "551"="南投縣", "552"="南投縣", "553"="南投縣", "555"="南投縣", "556"="南投縣", "557"="南投縣", "558"="南投縣", "600"="嘉義市", "602"="嘉義縣", "603"="嘉義縣", "604"="嘉義縣", "605"="嘉義縣", "606"="嘉義縣", "607"="嘉義縣", "608"="嘉義縣", "611"="嘉義縣", "612"="嘉義縣", "613"="嘉義縣", "614"="嘉義縣", "615"="嘉義縣", "616"="嘉義縣", "621"="嘉義縣", "622"="嘉義縣", "623"="嘉義縣", "624"="嘉義縣", "625"="嘉義縣", "630"="雲林縣", "631"="雲林縣", "632"="雲林縣", "633"="雲林縣", "634"="雲林縣", "635"="雲林縣", "636"="雲林縣", "637"="雲林縣", "638"="雲林縣", "640"="雲林縣", "643"="雲林縣", "646"="雲林縣", "647"="雲林縣", "648"="雲林縣", "649"="雲林縣", "651"="雲林縣", "652"="雲林縣", "653"="雲林縣", "654"="雲林縣", "655"="雲林縣", "700"="臺南市", "701"="臺南市", "702"="臺南市", "704"="臺南市", "708"="臺南市", "709"="臺南市", "710"="臺南市", "711"="臺南市", "712"="臺南市", "713"="臺南市", "714"="臺南市", "715"="臺南市", "716"="臺南市", "717"="臺南市", "718"="臺南市", "719"="臺南市", "720"="臺南市", "721"="臺南市", "722"="臺南市", "723"="臺南市", "724"="臺南市", "725"="臺南市", "726"="臺南市", "727"="臺南市", "730"="臺南市", "731"="臺南市", "732"="臺南市", "733"="臺南市", "734"="臺南市", "735"="臺南市", "736"="臺南市", "737"="臺南市", "741"="臺南市", "742"="臺南市", "743"="臺南市", "744"="臺南市", "745"="臺南市", "800"="高雄市", "801"="高雄市", "802"="高雄市", "803"="高雄市", "804"="高雄市", "805"="高雄市", "806"="高雄市", "807"="高雄市", "811"="高雄市", "812"="高雄市", "813"="高雄市", "814"="高雄市", "815"="高雄市", "817"="南海島", "819"="南海島", "820"="高雄市", "821"="高雄市", "822"="高雄市", "823"="高雄市", "824"="高雄市", "825"="高雄市", "826"="高雄市", "827"="高雄市", "828"="高雄市", "829"="高雄市", "830"="高雄市", "831"="高雄市", "832"="高雄市", "833"="高雄市", "840"="高雄市", "842"="高雄市", "843"="高雄市", "844"="高雄市", "845"="高雄市", "846"="高雄市", "847"="高雄市", "848"="高雄市", "849"="高雄市", "851"="高雄市", "852"="高雄市", "880"="澎湖縣", "881"="澎湖縣", "882"="澎湖縣", "883"="澎湖縣", "884"="澎湖縣", "885"="澎湖縣", "890"="金門縣", "891"="金門縣", "892"="金門縣", "893"="金門縣", "894"="金門縣", "896"="金門縣", "900"="屏東縣", "901"="屏東縣", "902"="屏東縣", "903"="屏東縣", "904"="屏東縣", "905"="屏東縣", "906"="屏東縣", "907"="屏東縣", "908"="屏東縣", "909"="屏東縣", "911"="屏東縣", "912"="屏東縣", "913"="屏東縣", "920"="屏東縣", "921"="屏東縣", "922"="屏東縣", "923"="屏東縣", "924"="屏東縣", "925"="屏東縣", "926"="屏東縣", "927"="屏東縣", "928"="屏東縣", "929"="屏東縣", "931"="屏東縣", "932"="屏東縣", "940"="屏東縣", "941"="屏東縣", "942"="屏東縣", "943"="屏東縣", "944"="屏東縣", "945"="屏東縣", "946"="屏東縣", "947"="屏東縣", "950"="臺東縣", "951"="臺東縣", "952"="臺東縣", "953"="臺東縣", "954"="臺東縣", "955"="臺東縣", "956"="臺東縣", "957"="臺東縣", "958"="臺東縣", "959"="臺東縣", "961"="臺東縣", "962"="臺東縣", "963"="臺東縣", "964"="臺東縣", "965"="臺東縣", "966"="臺東縣", "970"="花蓮縣", "971"="花蓮縣", "972"="花蓮縣", "973"="花蓮縣", "974"="花蓮縣", "975"="花蓮縣", "976"="花蓮縣", "977"="花蓮縣", "978"="花蓮縣", "979"="花蓮縣", "981"="花蓮縣", "982"="花蓮縣", "983"="花蓮縣"
```

- code2
```
"100"="中正區", "103"="大同區", "104"="中山區", "105"="松山區", "106"="大安區", "108"="萬華區", "110"="信義區", "111"="士林區", "112"="北投區", "114"="內湖區", "115"="南港區", "116"="文山區"
```

- code3
```
"100"="中正區", "103"="大同區", "104"="中山區", "105"="松山區", "106"="大安區", "108"="萬華區", "110"="信義區", "111"="士林區", "112"="北投區", "114"="內湖區", "115"="南港區", "116"="文山區"
```
