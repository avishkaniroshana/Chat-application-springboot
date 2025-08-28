import React from "react";
import chatIcon from "../assets/chat-icon.png";

const JoinCreateChat = () => {
  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="p-8 w-full flex flex-col gap-5 max-w-md rounded dark:bg-gray-700 shadow">
        <div>
          <img src={chatIcon} alt="chat icon" className="w-16 h-16 mx-auto" />
        </div>
        <h1 className="text-2xl font-bold text-center">
          Join or Create a Chat
        </h1>
        {/* For Name*/}
        <div className="">
          <label htmlFor="" className="block mb-2 font-medium text-white">
            Enter Name
          </label>
          <input
            type="text"
            className="border-0 border-b border-gray-600 bg-transparent text-gray-300 p-2 w-full focus:outline-none hover:border-white"
            placeholder="Your name"
          />
          {/* <input
            type="text"
            className="border border-gray-600 bg-gray-800 text-white rounded p-2 w-full"
            placeholder="Your name"
          /> */}
        </div>
        {/* For Room Id*/}
        <div className="">
          <label htmlFor="" className="block mb-2 font-medium text-white">
            Enter Room ID
          </label>
          <input
            type="text"
            className="border-0 border-b border-gray-600 bg-transparent text-gray-300 p-2 w-full focus:outline-none hover:border-white"
            placeholder="Your room id / new room id"
          />
        </div>
        {/* buttons */}
        <div className="flex justify-between mt-2">
          <button className="dark:bg-blue-400 hover:bg-blue-500 text-white rounded px-4 py-2">
            Join Chat
          </button>
          <button className="dark:bg-orange-400 hover:bg-orange-500 text-white rounded px-4 py-2">
            Create Chat
          </button>
        </div>
      </div>
    </div>
  );
};

export default JoinCreateChat;
