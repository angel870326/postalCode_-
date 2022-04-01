# Postal Code TW 郵遞區號

## 臺灣郵遞區號3碼對應縣市區

資料來源：https://www.post.gov.tw/post/internet/Download/index.jsp?ID=2292

### postalCode.java

|ArrayList|描述|
|-|-|
|code_city_area_raw|原始資料取郵遞區號前3碼、縣市名稱、鄉鎮市區，以逗號分隔|
|code_city_area|去除 code_city_area_raw 中重複的資料|
|code3_city_area|將 code_city_area 存成二維 ArrayList：郵遞區號前3碼, 縣市名稱, 鄉鎮市區|
|code3_city|二維 ArrayList：[郵遞區號前3碼, 縣市名稱]|
|code3_city_area_taipei|二維 ArrayList：[郵遞區號前3碼, 臺北市, 區名稱]|
|code3_city_area_newtaipei|二維 ArrayList：[郵遞區號前3碼, 新北市, 區名稱]|

|code|描述|
|-|-|
|code1|"`郵遞區號3碼`"="`縣市名稱`", "`郵遞區號3碼`"="`縣市名稱`", ...|
|code2|"`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", "`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", ...|
|code3|"`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", "`臺北市的郵遞區號3碼`"="`鄉鎮市區名稱`", ...|

