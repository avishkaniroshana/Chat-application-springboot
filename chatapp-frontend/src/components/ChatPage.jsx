import React from "react";
import { MdSend, MdAttachFile } from "react-icons/md";



const ChatPage = () => {

const [messages, setMessages] = React.useState([
  { sender: "Alice", content: "Hello!" },
  { sender: "Bob", content: "Hi there!" },
  { sender: "Charlie", content: "Hey everyone!" },

]);
const [input, setInput] = React.useState("");
const inputRef = React.useRef(null);
const chatBoxRef = React.useRef(null);
const [stompClient, setStompClient] = React.useState(null);
const [roomId, setRoomId] = React.useState("");
const [currentUser, setCurrentUser] = React.useState("Alice");



  return (
    <div className="">
      {/* This is header */}
      <header className="dark:border-gray-700 border fixed h-20 w-full dark:bg-gray-900 py-5 shadow flex justify-around items-center">
        {/* Room name container*/}
        <div>
          <h1 className="text-xl font-semibold">
            Room : <span>Family Room</span>
          </h1>
        </div>

        {/* User Name container */}
        <div>
          <h1 className="text-xl font-semibold">
            User : <span>John Doe</span>
          </h1>
        </div>

        {/* Button : leave chat */}

        <div>
          <button className="dark:bg-red-500 dark:hover:bg-red-700 text-white py-2 px-4 rounded">
            Leave Chat
          </button>
        </div>
      </header>

      <main className="py-21 w-full dark:bg-slate-600 mx-auto h-screen overflow-auto">
        {messages.map((messages, index) => (
          <div key={index} className={`flex ${messages.sender === currentUser ? "justify-end" : "justify-start"} px-3`}>
            <div className={`my-2 p-3 rounded-lg max-w-md ${messages.sender === currentUser ? "bg-green-400 text-right" : "bg-gray-400 text-left"}`}>
              <div className="flex flex-row gap-2">
                <img
                  className="w-10 h-10"
                  src={"https://avatar.iran.liara.run/public/27"}
                  alt=""
                />
                <div className=" flex flex-col gap-1">
                  <p className="text-sm font-bold text-black">
                    {messages.sender}
                  </p>
                  <p>{messages.content}</p>
                </div>
              </div>
            </div>
          </div>
        ))}
      </main>

      {/* Input message container */}
      <div className="fixed bottom-2 w-full h-16">
        <div className="h-full w-2/3 mx-auto dark:bg-gray-800 items-center flex justify-between px-3 rounded-full">
          <input
            type="text"
            placeholder="Type here..."
            className="px-5 py-2 dark:border-gray-700 dark:bg-gray-700 rounded-full h-12 min-w-11/12 text-white outline-none"
          />
          <button className=" bg-gray-800 hover:bg-gray-700 text-white rounded-full h-12 w-12 flex justify-center items-center">
            <MdAttachFile />
          </button>
          <button className=" bg-green-500 hover:bg-green-700 text-white rounded-full h-12 w-12 flex justify-center items-center">
            <MdSend />
          </button>
        </div>
      </div>
    </div>
  );
};

export default ChatPage;
