import http.server
import socketserver
from http import HTTPStatus
import datetime


class Handler(http.server.SimpleHTTPRequestHandler):
    i = 0
    last_access = None


    def do_GET(self):
        self.send_response(HTTPStatus.OK)
        self.end_headers()


        Handler.i += 1
        Handler.last_access = datetime.datetime.now()


        my_str = f'Hello world! This server has been accessed {Handler.i} times. Last access: {Handler.last_access}'


        self.wfile.write(bytes(my_str, 'utf-8'))


httpd = socketserver.TCPServer(('', 8093), Handler)
httpd.serve_forever()

