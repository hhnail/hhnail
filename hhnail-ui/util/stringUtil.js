const getTimeFromDecimal = (date) => {
    let template = '0000000'
    let result = ''
    const strDate = date.toString()
    template = template.substr(0, 6 - strDate.length) + strDate
    let index = 1;
    for (const tempChar of template) {
        result = result + tempChar
        if (index == 2 || index == 4) {
            result = result + ":"
        }
        index++
    }
    return result
}