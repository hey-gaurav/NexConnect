console.log("Script loaded")    

let currentTheme = getTheme();

//initial-->
document.addEventListener("DOMContentLoaded",()=>{      // This will call the method after our content has been loaded perfectly                  
    changeTheme();
});


function changeTheme() {
    //set to web page by adding class in html
    //document.querySelector("html").classList.add(currentTheme);
    changePageTheme(currentTheme, currentTheme);

    //set webpage listner to change theme button text
    const changeThemeButton = document.querySelector('#theme_change_button');

    const oldTheme = currentTheme;
    changeThemeButton.addEventListener("click", (event) => {
        console.log("Change theme button clicked")
        if (currentTheme == "dark") {
            //change to light
            currentTheme = "light";
        } else {
            // change to dark
            currentTheme = "dark";
        }
        changePageTheme(currentTheme, oldTheme);
    });
}

//set theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

//get theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    if (theme)
        return theme;
    else
        return "light";
}

//Change current page theme
function changePageTheme(theme, oldtheme) {
    // update into local storage
    setTheme(currentTheme);
    //remove current theme
    document.querySelector("html").classList.remove(oldtheme);
    //Add new theme to current theme
    document.querySelector("html").classList.add(theme);

    //change the text of button
    document
        .querySelector('#theme_change_button')
        .querySelector('span').textContent = theme == 'dark' ? 'Light' : 'Dark';
}