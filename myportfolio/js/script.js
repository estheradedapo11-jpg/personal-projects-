// Projects Slider 
function initProjectsSlider() {
    const sliderTrack = document.querySelector('#projects-preview .slider-track');
    const slides = document.querySelectorAll('#projects-preview .project-slide');
    const prevBtn = document.querySelector('#projects-preview .prev-btn');
    const nextBtn = document.querySelector('#projects-preview .next-btn');
    const indicators = document.querySelectorAll('#projects-preview .indicator');
    const currentSlideEl = document.querySelector('#projects-preview .current-slide');
    const totalSlidesEl = document.querySelector('#projects-preview .total-slides');
    
    if (!sliderTrack || !slides.length) return;
    
    let currentSlide = 0;
    const totalSlides = slides.length;
    
    // Update total slides display
    totalSlidesEl.textContent = totalSlides;
    
    // Function to update slider position
    function updateSlider() {
        // Move slider track
        sliderTrack.style.transform = `translateX(-${currentSlide * 100}%)`;
        
        // Update slide counter
        currentSlideEl.textContent = currentSlide + 1;
        
        // Update indicators
        indicators.forEach((indicator, index) => {
            indicator.classList.toggle('active', index === currentSlide);
        });
        
        // Update button states
        prevBtn.disabled = currentSlide === 0;
        nextBtn.disabled = currentSlide === totalSlides - 1;
        
        // Update button styles
        prevBtn.style.opacity = prevBtn.disabled ? '0.3' : '1';
        prevBtn.style.cursor = prevBtn.disabled ? 'not-allowed' : 'pointer';
        
        nextBtn.style.opacity = nextBtn.disabled ? '0.3' : '1';
        nextBtn.style.cursor = nextBtn.disabled ? 'not-allowed' : 'pointer';
    }
    
    // Next button click
    nextBtn.addEventListener('click', function() {
        if (currentSlide < totalSlides - 1) {
            currentSlide++;
            updateSlider();
        }
    });
    
    // Previous button click
    prevBtn.addEventListener('click', function() {
        if (currentSlide > 0) {
            currentSlide--;
            updateSlider();
        }
    });
    
    // Indicator clicks
    indicators.forEach((indicator, index) => {
        indicator.addEventListener('click', function() {
            currentSlide = index;
            updateSlider();
        });
    });
    
    // Auto-slide every 5 seconds
    let autoSlideInterval = setInterval(function() {
        if (currentSlide < totalSlides - 1) {
            currentSlide++;
        } else {
            currentSlide = 0;
        }
        updateSlider();
    }, 5000);
    
    // Pause auto-slide on hover
    const sliderContainer = document.querySelector('#projects-preview .projects-slider');
    sliderContainer.addEventListener('mouseenter', function() {
        clearInterval(autoSlideInterval);
    });
    
    sliderContainer.addEventListener('mouseleave', function() {
        autoSlideInterval = setInterval(function() {
            if (currentSlide < totalSlides - 1) {
                currentSlide++;
            } else {
                currentSlide = 0;
            }
            updateSlider();
        }, 5000);
    });
    
    // Touch/swipe support for mobile
    let startX = 0;
    let endX = 0;
    let isDragging = false;
    
    sliderContainer.addEventListener('touchstart', function(e) {
        startX = e.touches[0].clientX;
        isDragging = true;
    });
    
    sliderContainer.addEventListener('touchmove', function(e) {
        if (!isDragging) return;
        endX = e.touches[0].clientX;
    });
    
    sliderContainer.addEventListener('touchend', function() {
        if (!isDragging) return;
        isDragging = false;
        handleSwipe();
    });
    
    function handleSwipe() {
        const swipeThreshold = 50;
        const diff = startX - endX;
        
        if (Math.abs(diff) > swipeThreshold) {
            if (diff > 0 && currentSlide < totalSlides - 1) {
                // Swipe left - next
                currentSlide++;
            } else if (diff < 0 && currentSlide > 0) {
                // Swipe right - previous
                currentSlide--;
            }
            updateSlider();
        }
    }
    
    // Initialize slider
    updateSlider();
}


// Initialize when DOM is loaded
document.addEventListener('DOMContentLoaded', initProjectsSlider);
// JavaScript for Portfolio - Matching Your HTML
document.addEventListener('DOMContentLoaded', function() {
    console.log('Portfolio JavaScript loaded');
    
    // 1. RESUME DOWNLOAD BUTTONS
    const resumeButtons = document.querySelectorAll('.resumebutton, .preview-download-btn');
    
    resumeButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            alert('DOWNLOAD RESUME\n\nThis button would download my resume as a PDF file.');
        });
    });
    
    // 2. PROJECT BUTTONS/LINKS
    // For index.html (projects preview)
    const projectLinksIndex = document.querySelectorAll('.project-link.demo, .project-link.code');
    
    projectLinksIndex.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault();
            
            // Get project name from the h3 in the same card
            const projectCard = this.closest('.project-card');
            const projectName = projectCard ? 
                projectCard.querySelector('h3').textContent : 
                'My Project';
            
            // Check if it's a demo or code link
            if (this.classList.contains('demo')) {
                alert('VIEW DEMO: ' + projectName + '\n\nThis would show a live demo of this project.');
            } else if (this.classList.contains('code')) {
                alert('VIEW CODE: ' + projectName + '\n\nThis would show the code repository for this project.');
            }
        });
    });
    
    // For projects.html (main projects page)
    const projectLinksMain = document.querySelectorAll('.projects-page .project-link');
    
    projectLinksMain.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault();
            
            // Get project name from the h3 in the same card
            const projectCard = this.closest('.project-card');
            const projectName = projectCard ? 
                projectCard.querySelector('h3').textContent : 
                'My Project';
            
            // Check if it's "View Demo" or "View Code" by text content
            const linkText = this.textContent;
            
            if (linkText.includes('Demo')) {
                alert('VIEW DEMO: ' + projectName + '\n\nThis would show a live demo of this project.');
            } else if (linkText.includes('Code')) {
                alert('VIEW CODE: ' + projectName + '\n\nThis would show the code repository for this project.');
            } else {
                alert('PROJECT: ' + projectName + '\n\nThis would open the project page.');
            }
        });
    });
    
    // 3. FOOTER SOCIAL LINKS
    const footerLinks = document.querySelectorAll('footer .social-icon-link');
    
    footerLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault();
            
            // Get which social platform it is from the image alt text
            const img = this.querySelector('img');
            let platform = 'Social Media';
            
            if (img) {
                if (img.alt.includes('GitHub')) {
                    platform = 'GitHub';
                } else if (img.alt.includes('LinkedIn')) {
                    platform = 'LinkedIn';
                } else if (img.alt.includes('Email')) {
                    platform = 'Email';
                }
            }
            
            alert(platform.toUpperCase() + ' LINK\n\nThis would connect to my ' + platform + ' profile.');
        });
    });
    
    // 4. CONTACT FORM VALIDATION (for contactme.html)
    const contactForm = document.getElementById('formcontactme');
    
    if (contactForm) {
        contactForm.addEventListener('submit', function(event) {
            event.preventDefault();
            
            const name = document.getElementById('name').value.trim();
            const email = document.getElementById('email').value.trim();
            const message = document.getElementById('message').value.trim();
            
            let isValid = true;
            let errorMessage = '';
            
            if (!name) {
                isValid = false;
                errorMessage += 'Please enter your name\n';
            }
            
            if (!email) {
                isValid = false;
                errorMessage += 'Please enter your email\n';
            } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
                isValid = false;
                errorMessage += 'Please enter a valid email\n';
            }
            
            if (!message) {
                isValid = false;
                errorMessage += 'Please enter a message\n';
            } else if (message.length < 10) {
                isValid = false;
                errorMessage += 'Message must be at least 10 characters\n';
            }
            
            if (isValid) {
                alert('MESSAGE SENT\n\nThank you ' + name + '! Your message has been received.\n\nYou would receive a confirmation email at: ' + email + '\n\n(For this assignment, the form data is not actually sent.)');
                contactForm.reset();
            } else {
                alert('FORM ERROR\n\nPlease fix the following:\n\n' + errorMessage);
            }
        });
    }
});