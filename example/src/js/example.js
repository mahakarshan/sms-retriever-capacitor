import { sms } from 'sms-retriever';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    sms.echo({ value: inputValue })
}
