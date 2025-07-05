import React, { useState } from 'react';
import { getCustomer } from '../services/customerService';

const CustomerSearch = () => {
    const [customerId, setCustomerId] = useState('');
    const [customer, setCustomer] = useState(null);
    const [error, setError] = useState('');

    const handleSearch = async () => {
        setError('');
        setCustomer(null);
        try {
            const res = await getCustomer(customerId);
            setCustomer(res.data);
        } catch (err) {
            setError(err.response?.data?.error || 'Customer not found');
        }
    };

    return (
        <div>
            <input
                type="text"
                placeholder="Search by Customer ID"
                value={customerId}
                onChange={e => setCustomerId(e.target.value)}
            />
            <button onClick={handleSearch}>Search</button>
            {error && <div style={{ color: 'red' }}>{error}</div>}
            {customer && (
                <div>
                    <p><b>ID:</b> {customer.customerId}</p>
                    <p><b>Name:</b> {customer.firstName} {customer.lastName}</p>
                    <p><b>Email:</b> {customer.email}</p>
                </div>
            )}
        </div>
    );
};

export default CustomerSearch;