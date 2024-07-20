<?php
$loginUrl = 'https://api.blockcypher.com/v1/btc/main';
$ch = curl_init(); //初始化一个 cURL 会话
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_URL, $loginUrl); //为 cURL 会话设置选项
$result = curl_exec($ch); //获得 cURL 会话返回结果
curl_close($ch);
echo "After running the API url: " . $loginUrl . "<br>";
echo "The result of JSON data:<hr>";
var_dump($result); //将变量 result 输出到页面上
echo "<br><br>";
echo "<hr>";
echo "To JSON object data:<hr>";
$str = json_decode($result, true); //对 JSON 格式的字符串进行编码

echo "=============准备连接";

$servername = "localhost";
$username = "debian-sys-maint"; //填入你的数据库用户名
$password = "2SvthRgSkyfipymX"; //填入你的数据库密码
$dbname = "hw3"; //填入要使用的数据库名称
echo "<hr>";
echo "=============con before";
$conn = new mysqli($servername, $username, $password, $dbname);
echo "<br>";
echo "=============con after";

if ($conn->connect_error) {
    echo "=============连接失败";
    die("连接失败: " . $conn->connect_error);
}
$sql = "INSERT INTO record (name, height, hash, time) VALUES ('$str[name]','$str[height]', '$str[hash]', '$str[time]')";
echo "<br><br>";
if ($conn->query($sql) === TRUE) {
    echo "=============连接成功";
    echo "新记录插入成功";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
var_dump($str);
echo "<br><br>";
echo "<hr>";
echo "<table border=1>"; //开始构建表格
echo "<tr><td>Field</td><td></td></tr>";
$tm = $str["name"];
echo "<tr><td>Name:</td><td>" . $tm . "</td></tr>";
echo "<tr><td>height:</td><td>" . $str["height"] . "</td></tr>";
echo "<tr><td>hash:</td><td>" . $str["hash"] . "</td></tr>";
echo "<tr><td>time:</td><td>" . $str["time"] . "</td></tr>";
echo "</table>"
?>