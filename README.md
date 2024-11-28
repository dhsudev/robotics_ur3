# 🤖 robotics_ur3
A collection of exercises and projects to explore the features of UR3 robots.

---

## 📂 Basic Programs
In this folder, you'll find some of my initial programs to familiarize myself with the robot and its core functions.

---

## 🌐 Communicating with the Robot
Learning to communicate with the robot from external devices. This section explores different protocols, helping me understand their features and decide which to use in future projects.

### 🔌 Socket Communication
A socket server was implemented in **Java**, and a corresponding program was written for the robot to connect to this server.  
- **Process:** The robot sends its current position to the server and awaits a response with a new pose. Then it moves to that pose and returns to the previous one.
- This exercise helped deepen my understanding of network-based robot communication.

### 📡 XML-RPC
This exercise is similar to the socket implementation but utilizes the **XML-RPC protocol**.  
- It provides a different perspective on remote procedure calls and adds variety to the communication options tested.

### 🕵️‍♂️ Investigation Project
**Work in progress...**  

---

## 🛠️ URCaps Development
URCaps are a powerful way to customize the functionality of UR robots. This section documents my initial experiences and experiments.

### 🚀 Getting Started with URCaps
Basic exploration and understanding of URCaps.

### ✨ My Custom URCap for a Custom Grip
A custom URCap was developed to control a specialized gripper, tailored for specific tasks.

---

### 📜 Notes
This repository is a personal learning journey with UR3 robots. Contributions, suggestions, and discussions are always welcome!

