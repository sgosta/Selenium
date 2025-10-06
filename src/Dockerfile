FROM jenkins/jenkins:lts-jdk17

USER root

# ✅ Install Chrome
RUN apt-get update && apt-get install -y wget gnupg unzip && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# ✅ Install ChromeDriver matching the installed Chrome
RUN CHROME_VERSION=$(google-chrome --version | grep -oP '\d+\.\d+\.\d+\.\d+') && \
    DRIVER_URL="https://storage.googleapis.com/chrome-for-testing-public/${CHROME_VERSION}/linux64/chromedriver-linux64.zip" && \
    echo "Downloading ChromeDriver for version: ${CHROME_VERSION}" && \
    wget -O /tmp/chromedriver.zip "${DRIVER_URL}" || \
    (echo "Fallback: trying mainline latest release" && \
     wget -O /tmp/chromedriver.zip "https://storage.googleapis.com/chrome-for-testing-public/LATEST_RELEASE/linux64/chromedriver-linux64.zip") && \
    unzip -o /tmp/chromedriver.zip -d /usr/local/bin/ && \
    mv /usr/local/bin/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver && \
    chmod +x /usr/local/bin/chromedriver && \
    rm -rf /usr/local/bin/chromedriver-linux64 /tmp/chromedriver.zip

USER jenkins