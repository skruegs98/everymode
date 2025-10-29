// Everymode - Dynamic Content Generation
// This script generates feature cards, statistics, and team members dynamically

// ===== DATA ARRAYS =====

// Feature data array
const features = [
  {
    icon: '◉',
    title: 'Real-Time Scanning',
    description: 'Every commit is audited against WCAG 2.2 standards automatically',
    color: '#4285f4'
  },
  {
    icon: '✕',
    title: 'Auto-Block Non-Compliant Code',
    description: 'Prevent inaccessible code from reaching production',
    color: '#ea4335'
  },
  {
    icon: '⚡',
    title: 'CI/CD Integration',
    description: 'Seamlessly works with GitHub, GitLab, Jenkins, and more',
    color: '#f4b400'
  },
  {
    icon: '▦',
    title: 'Sprint-Ready Reports',
    description: 'Get actionable insights that fit your agile workflow',
    color: '#0F9D58'
  },
  {
    icon: '✓',
    title: 'Zero Accessibility Debt',
    description: 'Ship inclusive products from day one, not after remediation',
    color: '#4285f4'
  },
  {
    icon: '✓',
    title: 'VPAT Automation',
    description: 'Generate compliance documentation automatically',
    color: '#ea4335'
  }
];

// Statistics data array
const statistics = [
  {
    icon: '!',
    value: '95.9%',
    label: 'of top sites fail WCAG compliance',
    source: 'WebAIM, 2025',
    color: '#ea4335'
  },
  {
    icon: '↑',
    value: '300%+',
    label: 'increase in web accessibility lawsuits (2023–2025)',
    source: 'Accessibility.Works',
    color: '#f4b400'
  },
  {
    icon: '$',
    value: '$10K–$100K+',
    label: 'annual cost of retrofitting accessibility',
    source: 'Rivenburgh, 2025',
    color: '#0F9D58'
  }
];

// Team members data array
const teamMembers = [
  {
    name: 'Sarah Krueger',
    role: 'Co-Founder',
    image: 'images/team-member-1.jpg',
    color: '#4285f4'
  },
  {
    name: 'Micah Rembrandt',
    role: 'Technical Co-Founder',
    image: 'images/team-member-2.jpg',
    color: '#ea4335'
  },
  {
    name: 'Your Name',
    role: 'Web Accessibility Expert',
    image: 'images/team-member-3.jpg',
    color: '#0F9D58'
  }
];

// ===== DYNAMIC HTML GENERATION FUNCTIONS =====

/**
 * Creates feature cards dynamically from the features array
 */
function generateFeatureCards() {
  const container = document.getElementById('features-container');
  
  if (!container) {
    console.error('Features container not found');
    return;
  }

  // Clear existing content
  container.innerHTML = '';

  // Loop through features array and create HTML for each
  features.forEach((feature, index) => {
    const featureCard = document.createElement('article');
    featureCard.className = 'feature-card';
    
    featureCard.innerHTML = `
      <div class="feature-icon" aria-hidden="true" style="background: rgba(${hexToRgb(feature.color)}, 0.15); color: ${feature.color};">
        ${feature.icon}
      </div>
      <h3>${feature.title}</h3>
      <p>${feature.description}</p>
    `;
    
    container.appendChild(featureCard);
  });

  console.log(`Generated ${features.length} feature cards`);
}

/**
 * Creates statistics cards dynamically from the statistics array
 */
function generateStatistics() {
  const container = document.getElementById('stats-container');
  
  if (!container) {
    console.error('Statistics container not found');
    return;
  }

  container.innerHTML = '';

  statistics.forEach((stat, index) => {
    const statCard = document.createElement('article');
    statCard.className = 'stat-card';
    
    statCard.innerHTML = `
      <div class="stat-icon" aria-hidden="true" style="background: rgba(${hexToRgb(stat.color)}, 0.1); color: ${stat.color};">
        ${stat.icon}
      </div>
      <div class="stat-value">${stat.value}</div>
      <div class="stat-label">${stat.label}</div>
      <div class="stat-source">${stat.source}</div>
    `;
    
    container.appendChild(statCard);
  });

  console.log(`Generated ${statistics.length} statistic cards`);
}

/**
 * Creates team member cards dynamically from the teamMembers array
 */
function generateTeamCards() {
  const container = document.getElementById('team-container');
  
  if (!container) {
    console.log('Team container not found (may not be on this page)');
    return;
  }

  container.innerHTML = '';

  teamMembers.forEach((member, index) => {
    const teamCard = document.createElement('article');
    teamCard.className = 'team-card';
    teamCard.setAttribute('role', 'listitem');
    
    teamCard.innerHTML = `
      <img src="${member.image}" alt="" />
      <div class="team-card-content">
        <h3>${member.name}</h3>
        <p>${member.role}</p>
      </div>
    `;
    
    container.appendChild(teamCard);
  });

  console.log(`Generated ${teamMembers.length} team cards`);
}

// ===== UTILITY FUNCTIONS =====

/**
 * Converts hex color to RGB values for rgba() usage
 * @param {string} hex - Hex color code (e.g., '#4285f4')
 * @returns {string} - RGB values as string (e.g., '66, 133, 244')
 */
function hexToRgb(hex) {
  const result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
  if (result) {
    const r = parseInt(result[1], 16);
    const g = parseInt(result[2], 16);
    const b = parseInt(result[3], 16);
    return `${r}, ${g}, ${b}`;
  }
  return '0, 0, 0';
}

/**
 * Updates the copyright year in the footer
 */
function updateCopyrightYear() {
  const yearElement = document.getElementById('year');
  if (yearElement) {
    yearElement.textContent = new Date().getFullYear();
  }
}

// ===== INITIALIZATION =====

/**
 * Initialize all dynamic content when DOM is loaded
 */
document.addEventListener('DOMContentLoaded', function() {
  console.log('Everymode: Initializing dynamic content...');
  
  // Generate all dynamic content
  generateFeatureCards();
  generateStatistics();
  generateTeamCards();
  updateCopyrightYear();
  
  console.log('Everymode: Dynamic content generation complete');
});

// ===== EXPORTS (for potential future use) =====
// If using modules, you can export these functions
if (typeof module !== 'undefined' && module.exports) {
  module.exports = {
    features,
    statistics,
    teamMembers,
    generateFeatureCards,
    generateStatistics,
    generateTeamCards
  };
}
