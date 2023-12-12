import React, { useState } from 'react';

const App = () => {

    const [ name, setName ] = useState('')
    const [ email, setEmail ] = useState('')
    const [ message, setMessage ] = useState('')

    function handleSubmit(e) {
        e.preventDefault()
        console.log(name, email, message)
    }

  return (
    <form>
      <div>
        <label htmlFor="name">Name</label>
        <input type="text" id="name" name="name" value={name} onChange={e => setName(e.target.value)}/>
      </div>

      <div>
        <label htmlFor="email">Email</label>
        <input type="email" id="email" name="email" value={email} onChange={e => setEmail(e.target.value)}/>
      </div>

      <div>
        <label htmlFor="message">Message</label>
        <textarea id="message" name="message" value={message} onChange={e => setMessage(e.target.value)}/>
      </div>

      <button type="submit" onClick={handleSubmit}>Submit</button>
    </form>
  )
}

export default App;