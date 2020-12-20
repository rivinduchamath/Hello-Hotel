

var foodItems = [
    {
        name: "Pudding ",
        available : true
    },
    {
        name: "Jaffna ",
        available : false
    },
    {
        name: "Vanila M ",
        available : true
    }];

for (var  i = 0; i < foodItems.length; i++){
    if(foodItems[i].available === true){
        console.log("Available "+foodItems[i].name);
    }else {
        console.log("Not Available "+foodItems[i].name);
    }
}