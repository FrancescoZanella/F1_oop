# Use a base image that includes X11 libraries and Java
FROM mcr.microsoft.com/windows/servercore:ltsc2019


# Copy your application JAR and resources
COPY . /app

# Set the working directory
WORKDIR /app/out/production/F1_oop

# Set the entry point
CMD ["java", "graphics/TestApp"]
