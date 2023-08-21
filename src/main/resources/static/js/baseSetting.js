

function getCooks(key) {
    const array = document.cookie.split(";");
    const data = new Map();
    array.forEach(value => {
        const param = value.split("=");
        data.set(param[0],param[1]);
    })
     if (data.get(key)){
         return data.get(key)
     }
     return null;
}