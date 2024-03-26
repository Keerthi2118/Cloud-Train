from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

# Dummy users (replace this with a real user database)
users = {'username': 'password', 'user1': 'password1', 'user2': 'password2'}
users = {'username': 'password', 'user3': 'password3', 'user4': 'password4'}

@app.route('/', methods=['GET', 'POST'])
def login():
    error = None
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        if username in users and users[username] == password:
            return redirect(url_for('success', username=username))
        else:
            error = 'Invalid Credentials. Please try again.'
    return render_template('login.html', error=error)

@app.route('/success/<username>')
def success(username):
    return 'Logged in as ' + username

if __name__ == '__main__':
    app.run(debug=True)
