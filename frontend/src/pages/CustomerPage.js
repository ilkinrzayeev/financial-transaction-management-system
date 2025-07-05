import React, { useState } from 'react';
import CustomerForm from '../components/CustomerForm';
import CustomerSearch from '../components/CustomerSearch';

const CustomerPage = () => {
    const [refresh, setRefresh] = useState(false);

    return (
        <div>
            <h2>Customer Management</h2>
            <CustomerForm onSuccess={() => setRefresh(!refresh)} />
            <hr />
            <CustomerSearch key={refresh} />
        </div>
    );
};

export default CustomerPage;