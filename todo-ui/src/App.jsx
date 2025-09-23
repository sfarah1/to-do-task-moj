import { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/tasks");
      setTasks(res.data);
    } catch (err) {
      console.error("Error fetching tasks:", err);
    }
  };

  const addTask = async () => {
    if (!title.trim()) return;
    try {
      await axios.post("http://localhost:8080/api/tasks", {
        title,
        description,
        status: "TODO",
        dueAt: null,
      });
      setTitle("");
      setDescription("");
      fetchTasks();
    } catch (err) {
      console.error("Error creating task:", err);
    }
  };

  const deleteTask = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/tasks/${id}`);
      fetchTasks();
    } catch (err) {
      console.error("Error deleting task:", err);
    }
  };

  const updateStatus = async (id, newStatus) => {
    try {
      await axios.patch(`http://localhost:8080/api/tasks/${id}/status`, {
        status: newStatus,
      });
      fetchTasks();
    } catch (err) {
      console.error("Error updating task:", err);
    }
  };

  return (
    <div style={{ maxWidth: "600px", margin: "2rem auto", fontFamily: "Arial" }}>
      <h1>To-Do</h1>
      <div style={{ marginBottom: "1rem" }}>
        <input
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          style={{ display: "block", width: "100%", marginBottom: "0.5rem", padding: "8px" }}
        />
        <textarea
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          style={{ display: "block", width: "100%", marginBottom: "0.5rem", padding: "8px" }}
        />
        <button onClick={addTask} style={{ padding: "10px 20px" }}>
          Add Task
        </button>
      </div>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {tasks.map((task) => (
          <li
            key={task.id}
            style={{
              border: "1px solid #ccc",
              borderRadius: "8px",
              padding: "10px",
              marginBottom: "10px",
            }}
          >
            <h3>{task.title}</h3>
            <p>{task.description}</p>
            <p>Status: <strong>{task.status}</strong></p>
            <button
              onClick={() => updateStatus(task.id, task.status === "TODO" ? "DONE" : "TODO")}
              style={{ marginRight: "10px" }}
            >
              Toggle Status
            </button>
            <button onClick={() => deleteTask(task.id)} style={{ color: "red" }}>
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
