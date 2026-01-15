// Main function that calculates the time left
function calculation() {
    let userdate = document.getElementById("userexamtime");
    let titleevent = document.getElementById("eventname");

    // Convert user input into a date
    let examdate = new Date(userdate.value);
    let now = new Date();

    // Time difference in ms
    let diff = examdate - now;

    // Convert milliseconds into time components
    let days = Math.floor(diff / (1000 * 60 * 60 * 24));
    let hours = Math.floor((diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
    let seconds = Math.floor((diff % (1000 * 60)) / 1000);

    // Update countdown display
    document.getElementById("days").textContent = days + "D";
    document.getElementById("hours").textContent = hours + "H";
    document.getElementById("minutes").textContent = minutes + "M";
    document.getElementById("seconds").textContent = seconds + "S";

    // Update page title with event name
    document.querySelector("h1").textContent =
        "Counting Down to: " + titleevent.value;

    // If countdown has finished
    if (diff <= 0) {
        document.getElementById("days").textContent = "0D";
        document.getElementById("hours").textContent = "0H";
        document.getElementById("minutes").textContent = "0M";
        document.getElementById("seconds").textContent = "0S";

        document.querySelector("h1").textContent =
            titleevent.value + " has passed!";

        return; // Stop calculating
    }
}

// Run calculation every second
setInterval(calculation, 1000);

// Pre-loaded exam countdown (runs on page load)
function startCMPTcountdown() {
    document.getElementById("userexamtime").value = "2025-12-16T09:00";
    document.getElementById("eventname").value = "CMPT 281 Final Exam";
    calculation();
}

// Button triggers this
function startCountdown() {
    startUsercountdown();
}

// User-selected date countdown
function startUsercountdown() {
    calculation();
}

// Initialize preset countdown on page load
window.onload = startCMPTcountdown;
