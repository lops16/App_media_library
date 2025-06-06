document.getElementById("loginForm").addEventListener("submit", async function(event) {
    event.preventDefault(); 

    const passwordField = document.getElementById("p_pass");
    const password = passwordField.value;

    
    const encoder = new TextEncoder();
    const data = encoder.encode(password);
    const hashBuffer = await crypto.subtle.digest("SHA-256", data);

   
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');

    passwordField.style.visibility = 'hidden';
    passwordField.value = hashHex;

    console.log(passwordField);
    
    event.target.submit();
    passwordField.value = '';
});