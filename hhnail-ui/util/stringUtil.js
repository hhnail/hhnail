/**
 *
 * 将decimal类型的日期、时间转化为:\-等分隔符隔开的类型
 * @param date
 * @returns {string}
 *
 * eg
 * separator：:   091109 -> 09:11:09
 * separator：-   221209 -> 22-12-09
 *
 */
const getTimeFromDecimal = (date,separator) => {
    let template = '0000000'
    let result = ''
    const strDate = date.toString()
    template = template.substr(0, template.length - strDate.length) + strDate
    let index = 1;
    for (const tempChar of template) {
        result = result + tempChar
        if (index == 2 || index == 4) {
            result = result + separator
        }
        index++
    }
    return result
}
